import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Routes, Route, Navigate } from "react-router-dom";

import BoardListPage from "./page/BoardListPage"
import BoardRegisterPage from "./page/BoardRegisterPage"
import BoardReadPage from "./page/BoardReadPage"
import BoardModifyPage from "./page/BoardModifyPage"

const BoardApp = () => {
  return (
    <>
      <Routes>
        {/* exact의 경우 정확하게 이 경로에 해당하는 동작에 대해서만 BoardListPage가 동작한다 */}
        <Route element={<Navigate to="/react-board-app" replace/>} path="/" />
        <Route element={<BoardListPage/>} path="/react-board-app" exact></Route>
        <Route element={<BoardRegisterPage/>} path="/react-board-app/register"></Route>
        <Route element={<BoardReadPage/>} path="/react-board-app/read/:boardId"></Route>
        <Route element={<BoardModifyPage/>} path="/react-board-app/modify/:boardId"></Route>
      </Routes>
    </>
  )
};

export default BoardApp
