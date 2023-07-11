// 여기서 하위 컴포넌트들을 가져와서 import하여 브라우저에 띄우는 역할을 함

import React, { useEffect, useRef, useState } from "react";
import { BrowserRouter } from 'react-router-dom'

// 어떤건 {mount}, 어떤거는 그냥 App을 import하는 이유는? 차이점은?

// Vue Micro Frontend Apps
// import {'bootstrap mount 이름'} from 'remotes App 이름'/'remotes의 exposes 설정(오른쪽 이름)' 형태로 작성
import { mount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';
import { vuetifyTailwindBoardAppMount } from 'vuetifyTailwindBoardApp/vuetifyBoardBootstrap'

// import '사용하는 함수' from remotes-App'/'remotes의 exposes 설정(오른쪽 이름)' 형태로 작성
import Counter from 'reactModuleApp/Counter'
import BoardApp from 'reactBoardApp/BoardApp'
import ProductApp from "reactProductApp/ProductApp";
import ZustandTodoApp from "reactZustandTodoApp/ZustandTodoApp"
import ReactQueryTestApp from "reactQueryTestApp/ReactQueryTestApp"

// React에 vue를 붙일 때는 실제 React와 vue의 동작이 다르기 때문에
// React에 컴포넌트 형태로 붙이지 않고 
// bootstrap에서 실제 vue가 구동해서 그린 결과만 붙이기 위해 mount 계열을 사용합니다
// 고로 Vue 계열들은 전부 붙을 때 useRef() 계열과 useEffect() 계열을 사용하여 붙이고 있습니다

import VuetifyTailwindBoardAppRouterComponent from "./router/VuetifyTailwindBoardAppRouterComponent";

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)
  const vuetifyTailwindBoardRef = useRef(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)
  }, []);

  return (
    <div>
      <div style={{ zIndex: 999 }} ref={vuetifyNavigationRef} />
      <VuetifyTailwindBoardAppRouterComponent vuetifyTailwindBoardRef={vuetifyTailwindBoardRef} />
      {/* VuetifyTailwindBoardAppRouterComponent에 vuetifyTailwindBoardRef라는 prop이 전달됨 */}
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
      <ReactQueryTestApp />
      {/* <div style={{ zIndex: 999 }} ref={vuetifyNavigationRef} /> */}
    </div>
  )
};

export default App;