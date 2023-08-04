import React, { useEffect, useRef } from 'react'
import { useLocation } from "react-router-dom";

const VuetifyTypeScriptBoardApp = ({ eventBus }) => {
    const vueModuleRef = useRef(null);
    const isMountedRef = useRef(false);
    const location = useLocation()
  
    useEffect(() => {
      console.log('preparing mount vuetify board remotes app')

      if (!isMountedRef.current) {
        const loadRemoteComponent = async () => {
          const { vuetifyTailwindBoardAppMount } = await import('vuetifyTailwindBoardApp/vuetifyBoardBootstrap')
          vuetifyTailwindBoardAppMount(vueModuleRef.current, eventBus);
          isMountedRef.current = true;
        }
  
        loadRemoteComponent()
        console.log("Vuetify Board Remotes App ready: " + vueModuleRef)
      }
  
      return () => {
        eventBus.off('routing-event');
      };
    }, [])

    useEffect(() => {
        console.log('Vuetify Board 라우터 위치 바꿨어: ' + location.pathname)
        const handleNavigation = () => {
          console.log('handleNavigation()')
          if (location.pathname === "/vuetify-typescript-board-app") {
            console.log('라우터 변경')
            eventBus.emit('vuetify-board-routing-event', '/');
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

export default VuetifyTypeScriptBoardApp