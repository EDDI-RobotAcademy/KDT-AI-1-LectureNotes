import React from "react";
import ReactDOM from "react-dom";

/* 루트 컴포넌트를 정의하고 렌더링하는 역할을 합니다. */

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
        <Route element={<BoardListPage />} path="/" exact></Route>
        <Route element={<BoardRegisterPage />} path="/register"></Route>
        <Route element={<BoardReadPage />} path="/read/:boardId" exact></Route>
        <Route element={<BoardModifyPage />} path="/modify/:boardId" exact></Route>
    </Routes>
    </>
  )
};

export { App }
