import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Routes, Route } from "react-router-dom";

import BoardListPage from "./page/BoardListPage";
import BoardRegisterPage from "./page/BoardRegisterPage";

const App = () => {
  return (
    <>
      <Routes>
        <Route element={<BoardListPage />} path="/" exact></Route>
        <Route element={<BoardRegisterPage />} path="/register" exact></Route>
      </Routes>
    </>
  );
};

export { App };
