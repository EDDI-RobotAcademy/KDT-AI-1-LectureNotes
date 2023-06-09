import React from "react"

import "./index.css";
import { Routes, Route } from "react-router-dom"

import ProductListPage from "./page/ProductListPage"
import ProductRegisterPage from "./page/ProductRegisterPage"
import ProductReadPage from "./page/ProductReadPage"
import ProductModifyPage from "./page/ProductModifyPage"

const ProductApp = () => {
  return (
    <>
      <Routes>
        <Route element={<ProductListPage />} path="/" exact></Route>
        <Route element={<ProductRegisterPage />} path="/register" ></Route>
        <Route element={<ProductReadPage />} path="/read/:productId" ></Route>
        <Route element={<ProductModifyPage />} path="/modify/:productId" ></Route>
      </Routes>
    </>
  )
};

export default ProductApp