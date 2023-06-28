import React, { Suspense, useEffect, useRef, useState } from 'react'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';

import { Button } from '@mui/material'

import { navigationMount } from 'vueNavigationApp/VueNavigation';
import VuetifyTypeScriptBoardAppRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppRouter'

const MainRouter = () => {
  const vuetifyNavigationRef = useRef(null)
  const vuetifyTailwindBoardRef = useRef(null)

  const [naviHeight, setNaviHeight] = useState(0)
  const buttonRef = useRef(null)

  useEffect(() => {
    navigationMount(vuetifyNavigationRef.current)

    const updateNaviHeight = () => {
        const height = vuetifyNavigationRef.current.offsetHeight
        setNaviHeight(height)
    }

    const observer = new MutationObserver(updateNaviHeight)
    observer.observe(vuetifyNavigationRef.current, { attributes: true, childList: true, subtree: true})

    return () => {
        observer.disconnect()
    }
  }, [])

  useEffect(() => {
    console.log('vuetifyNavigationRef의 높이값: '+ naviHeight)
   }, [naviHeight])

 useEffect(() => {
    if( buttonRef.current ) {
        const buttonElement = buttonRef.current
        const computedStyled = getComputedStyle(buttonElement)
        const height = computedStyled.height

        console.log('버튼의 높이값: ' + height)
    }
 }, [])

  return (
    <div>
        <div ref={vuetifyNavigationRef}/>
        <Suspense fallback={<div>로딩중 ..........</div>}>
            <BrowserRouter>
                <div>
                    <div style={{ position: 'relative' }}>
                        <Button ref={buttonRef} component={Link} to="/" variant="contained">홈</Button>
                        <Button component={Link} to="/vuetify-typescript-board-app" variant="contained">Vuetify TypeScript Board App</Button>
                    </div>
                </div>
                <Routes>
                    <Route
                        exact path="/vuetify-typeacript-bard-app"
                        element={
                            <VuetifyTypeScriptBoardAppRouter
                                vuetifyNavigationRef={vuetifyTailwindBoardRef}
                                naviHeight={naviHeight}
                            />
                        }>
                        </Route>
                </Routes>
            </BrowserRouter>
        </Suspense>
    </div>
  )
}

export default MainRouter