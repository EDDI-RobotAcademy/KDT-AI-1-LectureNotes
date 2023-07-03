import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import VuetifyTailwindBoardComponent from './VuetifyTailwindBoardComponent'

const VuetifyTailwindBoardAppRouterComponent = ({ vuetifyTailwindBoardRef }) => {
  return (
    <BrowserRouter>
      <div>
        <Link to="/">홈</Link>
        <Link to="/vuetify-tailwind-board">Vue3 Vuetify3 게시판</Link>
      </div>
      <Routes>
        <Route path="/vuetify-tailwind-board" 
                element={<VuetifyTailwindBoardComponent vuetifyTailwindBoardRef={vuetifyTailwindBoardRef}/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default VuetifyTailwindBoardAppRouterComponent