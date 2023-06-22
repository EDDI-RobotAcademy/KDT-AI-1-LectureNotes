import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Routes, Route } from "react-router-dom";

import BoardListPage from "./page/BoardListPage";
import BoardRegisterPage from "./page/BoardRegisterPage";
import BoardReadPage from "./page/BoardReadPage";
import BoardModifyPage from "./page/BoardModifyPage";

const BoardApp = () => {
  return (
    <>
      <Routes>
        <Route element={<BoardListPage />} path="/" exact></Route>
        <Route element={<BoardRegisterPage />} path="/register" exact></Route>
        <Route element={<BoardReadPage />} path="/read/:boardId" exact></Route>
        <Route element={<BoardModifyPage />} path="/modify/:boardId" exact></Route>
      </Routes>
    </>
  )
};

export default BoardApp