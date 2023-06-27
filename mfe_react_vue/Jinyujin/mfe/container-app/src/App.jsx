// 여기서 하위 컴포넌트들을 가져와서 import하여 브라우저에 띄우는 역할을 함

import React, { useEffect, useRef, useState } from "react";
import { mount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';
import Counter from 'reactModuleApp/Counter'
import BoardApp from 'reactBoardApp/BoardApp'
import { BrowserRouter } from 'react-router-dom'
import ProductApp from "reactProductApp/ProductApp";
import ZustandTodoApp from "reactZustandTodoApp/ZustandTodoApp"

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)
  }, []);

  return (
    <div>
      <div style={{ zIndex: 999 }} ref={vuetifyNavigationRef} />
      <div style=
        {{
          margin: '10px', padding: '10px', textAlign: 'center',
          backgroundColor: 'cyan', position: 'relative'
        }}>
        <h1>나는 React로 만들어진 Container!</h1>
        <div ref={vueRef} />
      </div>
      <div style={{ position: 'relative' }}>
        <Counter/> 
        <BrowserRouter>
          <BoardApp />
          <ProductApp/>
        </BrowserRouter>
      </div>
      {/* 
        여기서도 Counter 페이지의 count가 먹혀야 하는데 div 밖에서는 안먹힘 
        -> position: relative로 해결
        이 속성을 사용하면 다른 요소들과 충돌을 피할 수 있음
      */}
      <ZustandTodoApp />
    </div>
  )
};

export default App;