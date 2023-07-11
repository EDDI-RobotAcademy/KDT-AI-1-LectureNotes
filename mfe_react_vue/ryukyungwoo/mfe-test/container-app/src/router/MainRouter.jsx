import React, { Suspense, useEffect, useRef, useState } from 'react'
import ReactDOM from "react-dom";
import {BrowserRouter, Link, Route, Routes, useNavigate} from 'react-router-dom';

import { Button } from '@mui/material'

import { navigationMount } from 'vueNavigationApp/VueNavigation';
import { mount } from 'vueModuleApp/Sample';
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
    const [activeService, setActiveService] = useState(null);
    const vueContainerRef = useRef(null);
    const reactContainerRef = useRef(null);

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

    const vueBoardAppRef = useRef(null);
    const reactBoardAppRef = useRef(null);

    const loadVueBoardApp = () => {
        setActiveService('vue');
    };

    const loadReactBoardApp = () => {
        setActiveService('react');
    };

    const vueButtonRef = useRef(null);

    const goToVueBoardApp = () => {
        // 버튼 클릭 시 동작할 로직
        console.log('Vue 게시판 버튼이 클릭되었습니다.');
        loadVueBoardApp()
    };

    const goToReactBoardApp = () => {
        // 버튼 클릭 시 동작할 로직
        console.log('React 게시판 버튼이 클릭되었습니다.');
        loadReactBoardApp()
    };

    useEffect(() => {
        const handleClick = (event) => {
            // 버튼이 클릭되었을 때의 동작을 처리
            if (event.target === buttonRef.current) {
                console.log('버튼이 클릭되었습니다.');
            }
        };

        // 이벤트 리스너 등록
        buttonRef.current.addEventListener('click', handleClick);

        // 컴포넌트 언마운트 시 이벤트 리스너 해제
        return () => {
            buttonRef.current.removeEventListener('click', handleClick);
        };
    }, []);


    return (
      <BrowserRouter>
    <div>
        <div ref={vuetifyNavigationRef} />
        <Suspense fallback={<div>로딩중 .........</div>}>
                <div>
                    <div>
                        {/* 버튼 클릭으로 Vue 게시판 Remotes App 로드 */}
                        <Button id="vueBoard" ref={buttonRef} onClick={goToVueBoardApp} variant="contained">
                            Vue 게시판
                        </Button>

                        {/* 버튼 클릭으로 React 게시판 Remotes App 로드 */}
                        <Button onClick={goToReactBoardApp} variant="contained">
                            React 게시판
                        </Button>
                    </div>
                </div>
                <Routes>
                    {/* React Container의 홈 화면 */}
                    <Route exact path="/" element={<Home buttonRef={buttonRef}/>} />

                    {/* Vue 게시판 Remotes App */}
                    {activeService === 'vue' && (
                        <Route path="/vue-module-app/" element={<VueModuleAppRouter vueModuleRef={vueModuleRef} buttonRef={buttonRef}/>} />
                    )}

                    {/* React 게시판 Remotes App */}
                    {activeService === 'react' && (
                        <Route path="/react-board-app/" element={<ReactBoardRoutes/>} />
                    )}
                </Routes>
            {/* Vue 게시판 Remotes App 컨테이너 */}
            {/*{activeService === 'vue' && <div ref={vueContainerRef}></div>}*/}

            {/* React 게시판 Remotes App 컨테이너 */}
            {/*{activeService === 'react' && <div ref={reactContainerRef}></div>}*/}
        </Suspense>
    </div>
      </BrowserRouter>
  )
}

export default MainRouter