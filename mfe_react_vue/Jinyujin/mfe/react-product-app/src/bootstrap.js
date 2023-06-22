import React from "react";
import ReactDOM from "react-dom";

import ProductApp from "./ProductApp";
import { BrowserRouter } from "react-router-dom"

ReactDOM.render(
    <BrowserRouter>
        <ProductApp />
    </BrowserRouter>,
    document.getElementById("react-product-module")
)