import React, { useEffect, useRef, useState } from "react"
import { BrowserRouter, Routes, Link, } from 'react-router-dom'

// Vue Micro Frontend Apps
// import { 'bootstrap mount 이름'} from 'remotes App'/'remotes의 exposes 설정(오른쪽이름)' 형태로 작성
import { mount } from 'vueModuleApp/Sample'
import { navigationMount } from 'vueNavigationApp/VueNavigation'
import { vuetifyTailwindBoardAppMount } from 'vuetifyTailwindBoardApp/vuetifyBoardBootstrap'

// React Micro Frontend Apps
// import '사용하는 함수' from 'remotes App'/'remotes의 exposes 설정(오른쪽이름)' 형태로 작성
import Counter from 'reactModuleApp/Counter'
import BoardApp from 'reactBoardApp/BoardApp'
import ProductApp from 'reactProductApp/ProductApp'
import TodoApp from "reactZustandTodoApp/ZustandTodoApp"
import ReactQueryTestApp from "reactQueryTestApp/ReactQueryTest"
import VuetifyTailwindBoardAppRouterComponent from "./router/VuetifyTailwindBoardAppRouterComponent"
// React에 vue를 붙일 때는 실제 React와 vue의 동작이 다르기 때문에
// React에 컴포넌트 형태로 붙이지 않고
// bootstrap에서 실제 vue가 구동해서 그린 결과만 붙이기 위해 mount 계열을 사용합니다.
// 고로 vue계열은 전부 붙을 때 useRef()계열과 useEffect()계열을 사용해서 붙이고 있스빈다.

const App = () => {
  const vueRef = useRef(null)
  const vuetifyNavigationRef = useRef(null)
  const vuetifyTailwindBoardRef =useRef(null)

  useEffect(() => {
    mount(vueRef.current)
    navigationMount(vuetifyNavigationRef.current)
  }, []);

  return (
    <div>
      <div style={{ zIndex: 999 }} ref={vuetifyNavigationRef}/>
        <div style={{position: 'relative'}}>
          <VuetifyTailwindBoardAppRouterComponent vuetifyTailwindBoardRef={vuetifyTailwindBoardRef}/>
        </div>
      <div style=
          {{ margin: '10px', padding: '10px', textAlign: 'center',
              backgroundColor: 'cyan', position: 'relative', zIndex: 1 }}>
        <h1>나는 React로 만들어진 Container!</h1>
        <div ref={vueRef}/>
      </div>
      <div style={{ position: 'relative' }}>
        <Counter/>
        <BrowserRouter>
          <BoardApp/>
          <ProductApp/>
        </BrowserRouter>
      </div>
      <TodoApp/>
      <ReactQueryTestApp/>
      {/* <div ref={vuetifyNavigationRef}/> */}
    </div>
  )
};

export default App;