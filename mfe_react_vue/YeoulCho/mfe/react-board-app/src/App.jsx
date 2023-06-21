import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Route, Routes } from "react-router-dom";
import BoardListPage from "./page/BoardListPage";

const App = () => {
  return(
  <>
    <Routes>
      <Route element={<BoardListPage/>} path="/" exact></Route>
    </Routes>
  </>
)};

export { App }
