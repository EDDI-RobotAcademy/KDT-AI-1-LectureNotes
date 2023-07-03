import React from "react";
import ReactDOM from "react-dom";

import "./index.css";
import { Route, Routes, Navigate } from "react-router-dom";
import ProductListPage from "./page/ProductListPage";
import ProductRegisterPage from "./page/ProductRegisterPage";
import ProductModifyPage from "./page/ProductModifyPage";
import ProductReadPage from "./page/ProductReadPage"

/* route 컴포넌트를 정의하고 렌더링을 하는 역할*/
const ProductApp = () => {
  return(
  <>
    <Routes>
      <Route path="/" element={<Navigate to="/react-product-app" replace/>} />
      <Route element={<ProductListPage/>} path="/react-product-app" exact></Route>
      <Route element={<ProductRegisterPage/>} path="/react-product-app/register" exact></Route>
      <Route element={<ProductReadPage/>} path="/react-product-app/read/:productId" exact></Route>
      <Route element={<ProductModifyPage/>} path="/react-product-app/modify/:productId" exact></Route>

    </Routes>
  </>
)};

export default ProductApp
