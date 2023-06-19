import React, { useEffect, useRef, useState } from "react";
import { mount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)
  }, []);

  return (
    <div>
      <div style=
          {{ margin: '10px', padding: '10px', textAlign: 'center', backgroundColor: 'cyan' }}>
        <h1>나는 React로 만들어진 Container!</h1>
        <div ref={vueRef}/>
      </div>
      <!-- 왜 ? 내리니까 정상적으로 동작하냐 ? -->
      <div ref={vuetifyNavigationRef}/>
    </div>
  )
};

export default App;
