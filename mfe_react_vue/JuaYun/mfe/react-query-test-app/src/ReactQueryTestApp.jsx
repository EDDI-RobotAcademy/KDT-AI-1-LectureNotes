import React from "react";
import ReactDOM from "react-dom";
// npm install react-query --save-dev
// npm install axios --save-dev


import { ReactQueryBasicStarter } from "./components/ReactQueryBasicStarter";

import "./index.css";

export const ReactQueryTestApp = () => (
  <div className="container">
    <div>
      <ReactQueryBasicStarter/>
    </div>
  </div>
);
export default ReactQueryTestApp