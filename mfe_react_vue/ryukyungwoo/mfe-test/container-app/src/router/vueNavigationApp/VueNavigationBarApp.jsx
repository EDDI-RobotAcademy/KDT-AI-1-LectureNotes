import React, { useEffect, useRef } from 'react'
import mitt from "mitt";
import {useLocation, useNavigate} from "react-router-dom";

const eventBus = mitt();

const VueNavigationBarApp = () => {

  const location = useLocation()
  const isMountedRef = useRef(false);

  const vuetifyNavigationRef = useRef(null)

  useEffect(() => {
    //navigationMount(vuetifyNavigationRef.current)

    if (!isMountedRef.current) {
        const loadRemoteComponent = async () => {
          const {navigationMount } = await import('vueNavigationApp/VueNavigation')
          navigationMount (vuetifyNavigationRef.current, eventBus);
          isMountedRef.current = true;
        }
  
        loadRemoteComponent()
      }
  
      return () => {
        eventBus.off('routing-event');
      };
  }, [])

  useEffect(() => {
    console.log('라우터 위치 바꿨어: ' + location.pathname)
    const handleNavigation = () => {
      console.log('handleNavigation()')
      if (location.pathname === "/vue-auth-app/sign-in") {
        console.log('라우터 변경')
        eventBus.emit('sign-in', '/vue-auth-app/sign-in');
        // eventBus.emit("module-unmount")
        // 다른 경로로 이동한 경우에만 eventBus의 구독 해제 등 정리 작업 수행
        // eventBus.off("dataReceived");
      }
    };

    // 컴포넌트가 마운트될 때 호출되는 이벤트 핸들러 등록
    handleNavigation();
  }, [location]);

  return (
    <div ref={vuetifyNavigationRef}/>
  )
}

export default VueNavigationBarApp