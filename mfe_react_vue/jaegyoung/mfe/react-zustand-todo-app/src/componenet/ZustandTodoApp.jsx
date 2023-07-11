import React from "react";
import "./../index.css";
import Header from "./Header";
import ZustandTodoLogic from "./ZustandTodoLogic";
import ZustandTodoList from "./ZustandTodoList";

const ZustTodoApp = () => {
  return(
    <div>
      <h2>나는 React로 만든 Zustand 기반 Todo App</h2>
      <Header/>
      <ZustandTodoLogic/>
      <ZustandTodoList/>
    </div>
  )
}
  

  

export default ZustTodoApp
