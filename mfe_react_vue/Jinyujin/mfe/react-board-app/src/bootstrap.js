import React from "react";
import ReactDOM from "react-dom";

import { App } from "./App";
import { BrowserRouter } from "react-router-dom"

ReactDOM.render(
    // vue에서 router랑 연결하는 과정과 동일함
    // vue에서는 use(router) 혹은 new Vue(router) 형식이었다면 React는 아래와 같이 구성함
    <BrowserRouter>
        <App />
    </BrowserRouter>,
    document.getElementById("react-board-module")
)

// BrowserRouter
// 페이지를 새로고침하지 않고도 주소를 변경할 수 있도록 해주고,
// 현재 주소에 관련된 정보를 props로 조회 및 사용이 가능하도록 한다.

// BrowserRouter는 리액트 라우터 돔을 적용하고 싶은 컴포넌트의 최상위 컴포넌트를 감싸주는 래퍼 컴포넌트이기 때문에, 
// 여기서는 App 컴포넌트를 감싸주면 된다