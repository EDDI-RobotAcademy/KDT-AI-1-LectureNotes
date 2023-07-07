import React, { useEffect, useRef, useState } from "react"
import { BrowserRouter, Routes, Link, } from 'react-router-dom'
import MainRouter from "./router/MainRouter";
const App = () => {
    return (
    <div>
      <MainRouter/>
    </div>
  )
};

export default App;