import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Routes, Route } from "react-router-dom";

import ProductListPage from "./page/ProductListPage"
import ProductRegisterPage from "./page/ProductRegisterPage"
import ProductReadPage from "./page/ProductReadPage"
import ProductModifyPage from "./page/ProductModifyPage"

const App = () => {
  return (
    <>
      <Routes>
        <Route element={<ProductListPage/>} path="/" exact></Route>
        <Route element={<ProductRegisterPage/>} path="/register" exact></Route>
        <Route element={<ProductReadPage/>} path="/read/:productId" exact></Route>
        <Route element={<ProductModifyPage/>} path="/modify/:productId" exact></Route>
      </Routes>
    </>
  )
};

export { App }