import React, { useEffect, useRef } from 'react'
//import mitt from "mitt";
import { useLocation } from "react-router-dom";

//const eventBus = mitt();

const VueAuthRemoteApp = ({ eventBus }) => {
    const vueModuleRef = useRef(null);
    const location = useLocation()
    const isMountedRef = useRef(false);
  
    useEffect(() => {
      console.log('preparing mount vue auth remotes app')

      if (!isMountedRef.current) {
        const loadRemoteComponent = async () => {
          const { vuetifyMemberAuthAppMount } = await import('vueAuthApp/VueAuth')
          vuetifyMemberAuthAppMount(vueModuleRef.current, eventBus);
          isMountedRef.current = true;
        }
  
        loadRemoteComponent()
        console.log("Vue Auth Remotes App ready: " + vueModuleRef)
      }
  
      return () => {
        eventBus.off('routing-event');
      };
    }, [])

    // 현재 OAuth 로직은 리다이렉션을 하기 때문에 사실상 이 부분이 실행될일이 없음
    // 추후 EventBus 서비스를 별개로 구성한다면 이 부분이 활성화될 것
    useEffect(() => {
      eventBus.on('go-to-home', () => {
          console.log('received go-to-home event')
          //renderAuthApp = true;
          //navigate('/')
          //window.location.href = 'http://localhost:3000/'
      });

      return () => {
          eventBus.off('go-to-home');
      };
  }, []);
  
    useEffect(() => {
      console.log('여긴 Vue AUth Remote App - 라우터 위치 바꿨어: ' + location.pathname)
      const handleNavigation = () => {
        console.log('handleNavigation()')
        if (location.pathname === "/vue-auth-app") {
          console.log('Auth App 라우터 변경')
          //eventBus.emit('routing-event', '/');
          // eventBus.emit("module-unmount")
          // 다른 경로로 이동한 경우에만 eventBus의 구독 해제 등 정리 작업 수행
          // eventBus.off("dataReceived");
        }
      };
  
      // 컴포넌트가 마운트될 때 호출되는 이벤트 핸들러 등록
      handleNavigation();
    }, [location]);
  
    return (
      <div>
        <div>
          <div style={{ position: 'relative' }} ref={vueModuleRef}/>
        </div>
      </div>
    )
}

export default VueAuthRemoteApp