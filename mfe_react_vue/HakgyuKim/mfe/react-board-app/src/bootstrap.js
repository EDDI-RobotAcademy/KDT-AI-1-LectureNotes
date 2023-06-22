import React from "react";
import ReactDOM from "react-dom";

import { App } from './App'
import { BrowserRouter } from 'react-router-dom'

ReactDOM.render(
    // Vue Router 연결하는 과정과 동일함
    // Vue에서는 use(router) 혹은 new Vue (router) 형식이었다면 React는 아래와 같이 구성함
    <BrowserRouter>
        <App/>
    </BrowserRouter>,
    document.getElementById("react-board-module")
)
