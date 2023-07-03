import React, { Suspense, useEffect, useRef, useState } from 'react'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';

import { Button } from '@mui/material'

import { navigationMount } from 'vueNavigationApp/VueNavigation';
import VuetifyTypeScriptBoardAppRouter from './vuetifyTypeScriptBoardApp/VuetifyTypeScriptBoardAppRouter';
import VueModuleAppRouter from './vueModuleApp/VueModuleAppRouter';
import ReactCounterAppRouter from './reactModuleApp/ReactCounterAppRouter'
import Home from './containerApp/Home';
import ReactBoardRoutes from './reactBoardApp/ReactBoardRoutes';
import ReactTypescriptMuiBoardRoutes from './muiTypeScriptBoardApp/ReactTypeScriptMuiBoardRoutes';
import VueModuleAppRegisterRouter from './vueModuleApp/VueModuleAppRegisterRouter';
import VueModuleAppReadRouter from './vueModuleApp/VueModuleAppReadRouter';
import VueModuleAppModifyRouter from './vueModuleApp/VueModuleAppModifyRouter';
import VueModuleAppListRouter from './vueModuleApp/VueModuleAppListRouter';
import VuetifyBoardAppListRouter from './vuetifyTypeScriptBoardApp/VuetifyBoardAppListRouter';
import VuetifyBoardAppRegisterRouter from './vuetifyTypeScriptBoardApp/VuetifyBoardAppRegisterRouter';
import VuetifyBoardAppReadRouter from './vuetifyTypeScriptBoardApp/VuetifyBoardAppReadRouter';
import VuetifyBoardAppModifyRouter from './vuetifyTypeScriptBoardApp/VuetifyBoardAppModifyRouter';

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
                            <Button component={Link} to="/vue-module-app" variant="contained">
                                Vue 게시판
                            </Button>
                            <Button component={Link} to="/react-counter-app" variant="contained">
                                React 카운터
                            </Button>
                            <Button component={Link} to="/react-board-app" variant="contained">
                                React 게시판
                            </Button>
                            <Button component={Link} to="/react-query-zustand-mui-typescript-board-app" variant="contained">
                                Mui TypeSrcipt 게시판
                            </Button>
                        </div>
                    </div>
                    <Routes>
                        <Route
                            exact path="/"
                            element={<Home />}
                        />
                        <Route
                            exact path="/vuetify-typescript-board-app"
                            element={
                                <VuetifyTypeScriptBoardAppRouter
                                    vuetifyTailwindBoardRef={vuetifyTailwindBoardRef}
                                />
                            } />
                        {/* <Route
                            exact path="/vue-module-app"
                            element={
                                <VueModuleAppRouter
                                    vueModuleRef={vueModuleRef}
                                />
                            } /> */}
                        <Route
                            exact path="/react-counter-app"
                            element={
                                <ReactCounterAppRouter />
                            } />
                    </Routes>
                    <ReactBoardRoutes />
                    <ReactTypescriptMuiBoardRoutes />
                    <Routes>
                        <Route
                            exact path="/vue-module-app"
                            element={
                                <VueModuleAppListRouter />
                            } />
                        <Route
                            exact path="/vue-module-app/board-register-page"
                            element={
                                <VueModuleAppRegisterRouter />
                            } />
                        <Route
                            exact path="/vue-module-app/board-read-page/:boardId"
                            element={
                                <VueModuleAppReadRouter />
                            } />
                        <Route
                            exact path="/vue-module-app/board-modify-page/:boardId"
                            element={
                                <VueModuleAppModifyRouter />
                            } />
                    </Routes>
                    <Routes>
                        <Route
                            exact path="/vuetify-typescript-board-app"
                            element={
                                <VuetifyBoardAppListRouter />
                            } />
                        <Route
                            exact path="/vuetify-typescript-board-app/register"
                            element={
                                <VuetifyBoardAppRegisterRouter />
                            } />
                        <Route
                            exact path="/vuetify-typescript-board-app/read/:boardId"
                            element={
                                <VuetifyBoardAppReadRouter />
                            } />
                        <Route
                            exact path="/vuetify-typescript-board-app/modify/:boardId"
                            element={
                                <VuetifyBoardAppModifyRouter />
                            } />
                    </Routes>
                </BrowserRouter>
            </Suspense>
        </div>
    )
}

export default MainRouter