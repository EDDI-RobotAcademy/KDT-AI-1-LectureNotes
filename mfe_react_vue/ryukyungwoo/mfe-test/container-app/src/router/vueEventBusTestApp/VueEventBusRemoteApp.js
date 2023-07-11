import React, {useEffect, useRef, useState} from "react";
import ReactDOM from 'react-dom'

import mitt from "mitt";
import {useLocation, useNavigate} from "react-router-dom";

const eventBus = mitt();

const VueEventBusRemoteApp = () => {
    const [message, setMessage] = useState('');
    const vueModuleRef = useRef(null);
    const navigate = useNavigate()
    const location = useLocation()
    const isMountedRef = useRef(false);

    console.log('vueModuleRef.current = ' + vueModuleRef.current)

    const handleOtherButtonClick = async () => {
        setMessage('클릭했음');
        eventBus.emit('dataReceived', 'Hello from React Container App!');
    };

    useEffect(() => {
        console.log('언제 실행됨 ? VueEventBusRemoteApp 컴포넌트가 실행될 때')
        console.log('현재 vueModuleRef.current = ' + vueModuleRef.current)

        if (!isMountedRef.current) {
            console.log('VueEventBusRemoteApp 실행!')
            const mountVueComponent = async () => {
                const {mount} = await import('vueEventBusTestApp/VueRemotesApp');
                mount(vueModuleRef.current, eventBus);
                isMountedRef.current = true;
            };

            mountVueComponent();
        }

        return () => {
            // 컴포넌트가 언마운트될 때 정리(cleanup) 함수 실행
            eventBus.off('dataReceived');
        };
    }, []);

    useEffect(() => {
        console.log('이거 호출되긴 하냐 ? ' + location.pathname)
        const handleNavigation = () => {
            console.log('handleNavigation()')
            if (location.pathname !== "/vue-event-bus-test") {
                console.log('라우터 변경')
                eventBus.emit("module-unmount")
                // 다른 경로로 이동한 경우에만 eventBus의 구독 해제 등 정리 작업 수행
                eventBus.off("dataReceived");
            }
        };

        // 컴포넌트가 마운트될 때 호출되는 이벤트 핸들러 등록
        handleNavigation();
    }, [location]);

    return (
        <div>
            <div style={{ position: 'relative' }}>
                <button onClick={handleOtherButtonClick}>Vue Remotes로 Emit Event</button>
                <p>{message}</p>
                <div ref={vueModuleRef} />
            </div>
        </div>
    );
};

export default VueEventBusRemoteApp;



