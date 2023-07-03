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

  return (
    <div ref={vuetifyNavigationRef}/>
  )
}

export default VueNavigationBarApp