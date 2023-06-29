import React, { Suspense } from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import TypescriptBoardListPage from '../page/TypescriptBoardListPage'

const MainRouter = () => {
  return (
    <div>
      <Suspense fallback={<div>로딩중 ........</div>}>
        <Routes>
          <Route path="/" element={<Navigate to="/react-query-zustand-mui-typescript-board-app" replace/>}/>
          <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage/>}/>
        </Routes>
      </Suspense>
    </div>
  )
}

export default MainRouter