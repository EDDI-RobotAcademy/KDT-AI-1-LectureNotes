import React, { Suspense, useEffect, useRef, useState } from 'react'
import ReactDOM from "react-dom";
import {BrowserRouter, Link, Route, Routes, useNavigate} from 'react-router-dom';

import { Button } from '@mui/material'

import { navigationMount } from 'vueNavigationApp/VueNavigation';
import VuetifyTypeScriptBoardAppRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppRouter';
import VueModuleAppRouter from './vueModuleApp/VueModuleAppRouter';
import Home from './containerApp/Home';
import ReactCounterAppRouter from './reactModuleApp/ReactCounterAppRouter';
import ReactBoardRoutes from './reactBoardApp/ReactBoardRoutes';
import ReactTypescriptMuiBoardRoutes from './muiTypescriptBoardApp/ReactTypescriptMuiBoardRoutes';
import VueModuleAppRegisterRouter from './vueModuleApp/VueModuleAppRegisterRouter';
import VueModuleAppReadRouter from './vueModuleApp/VueModuleAppReadRouter';
import VueModuleAppModifyRouter from './vueModuleApp/VueModuleAppModifyRouter';
import VueModuleAppListRouter from './vueModuleApp/VueModuleAppListRouter';
import VuetifyTypeScriptBoardAppRegisterRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppRegisterRouter';
import VuetifyTypeScriptBoardAppReadRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppReadRouter';
import VuetifyTypeScriptBoardAppModifyRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppModifyRouter';

const MainRouter = () => {
  const vueModuleRef = useRef(null)
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
    observer.observe(vuetifyNavigationRef.current, { attributes: true, childList: true, subtree: true })

    return () => {
        observer.disconnect()
    }
  }, [])

  useEffect(() => {
    console.log('vuetifyNavigationRef의 높이값: ' + naviHeight)
  }, [naviHeight])

  useEffect(() => {
    if (buttonRef.current) {
        const buttonElement = buttonRef.current
        const computedStyle = getComputedStyle(buttonElement)
        const height = computedStyle.height

        console.log('버튼의 높이값: ' + height)
    }
  }, [])

    const goToVueBoardApp = () => {
      console.log('이거 되냐 ?')

        if (vueModuleRef.current) {
            console.log('응 돼')
            const vueBoardRoute = async () => {
                const {routingPath} = await import('vueModuleApp/Sample');
                routingPath(vueModuleRef.current, '/vue-module-app');
            };

            vueBoardRoute()
        }
    }

    const renderReactList = () => {
        return (
            <React.Fragment>
                {/* 다른 React 컴포넌트들 */}
                <ReactBoardRoutes containerModuleRef={vueModuleRef} />
            </React.Fragment>
        );
    };
    
    const goToReactBoardApp = () => {
      console.log('ref 떼어내고 react 붙이기')

        const reactList = renderReactList();
        ReactDOM.render(reactList, vueModuleRef.current);
    }

  return (
    <div>
        <div ref={vuetifyNavigationRef} />
        <Suspense fallback={<div>로딩중 .........</div>}>
          <BrowserRouter>
            <div>
              <div style={{ position: 'relative' }}>
                <Button ref={buttonRef} component={Link} to="/" variant="contained">
                  홈
                </Button>
                <Button component={Link} to="/vuetify-typescript-board-app" variant="contained">
                  Vuetify TypeScript 게시판
                </Button>
                  {vueModuleRef.current == null ? (
                      <Button component={Link} to="/vue-module-app" variant="contained">
                          Vue 게시판
                      </Button>
                  ) : (
                      <Button onClick={ goToVueBoardApp } variant="contained">
                          Vue 게시판(객체할당)
                      </Button>
                  )}
                <Button component={Link} to="/react-counter-app" variant="contained">
                  React 카운터
                </Button>
                  {vueModuleRef.current ? (
                      <Button onClick={ goToReactBoardApp } variant="contained">
                          React 게시판 (ref 떼어내기)
                      </Button>
                  ) : (
                      <Button component={Link} to="/react-board-app" variant="contained">
                          React 게시판
                      </Button>
                  )}
                {/*<Button component={Link} to="/react-board-app" variant="contained">*/}
                {/*  React 게시판*/}
                {/*</Button>*/}
                <Button component={Link} to="/react-query-zustand-mui-typescript-board-app" variant="contained">
                  Mui Typescript 게시판
                </Button>
              </div>
            </div>
            <Routes>
              <Route
                exact path="/"
                element={<Home/>}
                />
              <Route
                exact path="/vuetify-typescript-board-app"
                element={
                  <VuetifyTypeScriptBoardAppRouter
                    vuetifyTailwindBoardRef={vuetifyTailwindBoardRef}
                  /> 
                }/>
              <Route
                exact path="/react-counter-app"
                element={
                  <ReactCounterAppRouter/>
                }/>
            </Routes>
            <ReactBoardRoutes containerModuleRef={ vueModuleRef }/>
            <ReactTypescriptMuiBoardRoutes/>
            <Routes>
              <Route
                exact path="/vue-module-app"
                element={
                  <VueModuleAppListRouter vueModuleListRef={ vueModuleRef }/>
                }/>
              <Route
                exact path="/vue-module-app/board-register-page"
                element={
                  <VueModuleAppRegisterRouter vueModuleRegisterRef={ vueModuleRef }/>
                }/>
              <Route
                exact path="/vue-module-app/board-read-page/:boardId"
                element={
                  <VueModuleAppReadRouter vueModuleReadRef={ vueModuleRef }/>
                }/>
              <Route
                exact path="/vue-module-app/board-modify-page/:boardId"
                element={
                  <VueModuleAppModifyRouter vueModuleModifyRef={ vueModuleRef }/>
                }/>
            </Routes>
            <Routes>
              <Route
                exact path="/vuetify-typescript-board-app/register"
                element={
                  <VuetifyTypeScriptBoardAppRegisterRouter/>
                }/>
              <Route
                exact path="/vuetify-typescript-board-app/read/:boardId"
                element={
                  <VuetifyTypeScriptBoardAppReadRouter/>
                }/>
              <Route
                exact path="/vuetify-typescript-board-app/modify/:boardId"
                element={
                  <VuetifyTypeScriptBoardAppModifyRouter/>
                }/>
            </Routes>
          </BrowserRouter>
        </Suspense>
    </div>
  )
}

export default MainRouter