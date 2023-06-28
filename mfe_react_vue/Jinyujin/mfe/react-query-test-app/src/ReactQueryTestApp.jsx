import React from "react";
import ReactDOM from "react-dom";

import {ReactQueryBasicStarter} from "./components/ReactQueryBasicStarter";
// ReactQueryBasicStarter 페이지에서 export를 어디에 하냐에 따라 
// {}를 붙일지 안붙일지 정해지는 것
// 네비게이션 바처럼 export를 하면 {}를 붙이고 
// ReactQueryBasicStarter 페이지처럼 export하면 그냥 import
// 수업진행하면서 달라짐

import "./index.css";

const ReactQueryTestApp = () => (
  <div className="container">
    <ReactQueryBasicStarter/>
  </div>
);
export default ReactQueryTestApp