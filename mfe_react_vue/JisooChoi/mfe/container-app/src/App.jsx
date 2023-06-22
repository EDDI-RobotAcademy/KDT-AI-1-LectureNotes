import React, { useEffect, useRef, useState } from "react";
import { mount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';
import Counter from 'reactModuleApp/Counter';
import BoardApp from 'reactBoardApp/BoardApp'
import { BrowserRouter } from 'react-router-dom'

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)

  const [ReactBoardApplication, setReactBoardApplication] = useState(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)

    const loadReactBoardApplication = async () => {
      const { default: App } = await import('reactBoardApp/ReactBoardApplication')
      setReactBoardApplication(() => App)

    }

    loadReactBoardApplication()
  }, []);

  if (!ReactBoardApplication) {
    return <div>로딩중이니까 기다리세요</div>
  }

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
      <BrowserRouter>
        <BoardApp/>
      </BrowserRouter>
    </div>
  )
};

export default App;