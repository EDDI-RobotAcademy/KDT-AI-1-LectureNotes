import React from 'react'
import Header from './Header'
import ZustandTodoLogic from './ZustandTodoLogic'

const ZustandTodoApp = () => {
  return (
    <div>
      <h2>나는 React로 만든 Zustand 기반 Todo App</h2>
      <Header/>
      <ZustandTodoLogic/>
    </div>
  )
}

export default ZustandTodoApp