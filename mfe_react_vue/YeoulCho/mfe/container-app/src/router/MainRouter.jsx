import React, { Suspense, useEffect, useRef, useState } from 'react'
import { BrowserRouter, Link } from 'react-router-dom'
import {Button}  from '@mui/material'
import { navigationMount } from 'vueNavigationApp/VueNavigation'

const MainRouter = () => {
    const vuetifyNavigationRef = useRef(null)

    const [naviHeight, setNaviHeight] = useState(0)
    const buttonRef = useRef(null)

    useEffect(()=>{
        navigationMount(vuetifyNavigationRef.current)
        const updateNaviHeight = () => {
            const height = vuetifyNavigationRef.current.offsetHeight
            setNaviHeight(height)    
        } 

        const observer = new MutationObserver(updateNaviHeight)
        observer.observe(vuetifyNavigationRef.current, {attributes: true, childList: true, subtree: true})

        return ()=>{
            observer.disconnect()
        }
    }, [])

    useEffect(()=>{
        console.log('vuetifyNavigationRef의 높이 값' + naviHeight)
    }, [naviHeight])

    useEffect(()=>{
        if(buttonRef.current){
            const buttonElement = buttonRef.current
            const computedStyle = getComputedStyle(buttonElement)
            const height = computedStyle.height

            console.log('높이값: ' + height)
        }
    },[])
  return (
    <div>
        <div ref={vuetifyNavigationRef}/>
        <Suspense fallback={<div> 로딩중..........</div>}>
            <BrowserRouter>
            <div>
                <div style={{position: 'relative'}}>
                    <Button ref={buttonRef} component={Link} to="/" varient="contained">홈</Button>
                </div>
            </div>
            </BrowserRouter>
        </Suspense>
    </div>
  )
}

export default MainRouter