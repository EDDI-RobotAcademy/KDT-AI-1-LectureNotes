import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Routes, Route } from "react-router-dom";

import BoardListPage from "./page/BoardListPage"
import BoardRegisterPage from "./page/BoardRegisterPage"
import BoardReadPage from "./page/BoardReadPage"
import BoardModifyPage from "./page/BoardModifyPage"

const App = () => {
  return (
    <>
      <Routes>
        {/* exact의 경우 정확하게 이 경로에 해당하는 동작에 대해서만 BoardListPage가 동작한다 */}
        <Route element={<BoardListPage/>} path="/" exact></Route>
        <Route element={<BoardRegisterPage/>} path="/register"></Route>
        <Route element={<BoardReadPage/>} path="/read/:boardId"></Route>
        <Route element={<BoardModifyPage/>} path="/modify/:boardId"></Route>
      </Routes>
    </>
  )
};

export { App }
