import React, { useEffect, useRef, useState } from "react";
import { mount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';
import Counter from 'reactModuleApp/Counter';

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)
  }, []);

  return (
    <div>
      <div style={{ zIndex: 999 }} ref={vuetifyNavigationRef}/>
      <div style=
          {{ margin: '10px', padding: '10px', textAlign: 'center',
              backgroundColor: 'cyan', position: 'relative', zIndex: 1 }}>
        <h1>나는 React로 만들어진 Container!</h1>
        <div ref={vueRef}/>
      </div>
      <Counter/>
    </div>
  )
};

export default App;
