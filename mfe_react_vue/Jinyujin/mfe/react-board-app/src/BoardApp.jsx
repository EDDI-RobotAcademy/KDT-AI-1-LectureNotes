import React from "react";
import ReactDOM from "react-dom";

import "./index.css";

import { Routes, Route } from "react-router-dom";
import BoardListPage from "./page/BoardListPage";
// 위 두 줄은 쓸써면 import 해줬어야 함!
// react-router-dom은 npm install로 설치해준 상태
import BoardRegisterPage from './page/BoardRegisterPage'
import BoardReadPage from './page/BoardReadPage'
import BoardModifyPage from './page/BoardModifyPage'

const BoardApp = () => {
  return (
    <>
      <Routes>
        <Route element={<BoardListPage/>} path="/" exact></Route>
        <Route element={<BoardRegisterPage/>} path="/register" exact></Route>
        <Route element={<BoardReadPage/>} path="/read/:boardId" exact></Route>
        <Route element={<BoardModifyPage/>} path="/modify/:boardId" exact></Route>
      </Routes>
    </>
  )
};
// /:boardId 이렇게 하면 Vue랑 똑같이 가변인자로 사용 가능
export default BoardApp