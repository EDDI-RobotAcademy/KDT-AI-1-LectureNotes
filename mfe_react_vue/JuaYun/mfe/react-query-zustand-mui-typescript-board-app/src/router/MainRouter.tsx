import React, { Suspense } from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import TypeScriptBoardListPage from '../page/TypeScriptBoardListPage'
import TypeScriptBoardRegisterPage from '../page/TypeScriptBoardRegisterPage'

const MainRouter = () => {
  return (
    <div>
      <Suspense fallback={<div>로딩중</div>}>
        <Routes>
          <Route path="/" element={<Navigate to="/react-query-zustand-typescript-board-app" replace/>}/>
          <Route path="/react-query-zustand-typescript-board-app" element={<TypeScriptBoardListPage/>}/>
          <Route path="/react-query-zustand-typescript-board-app/register" element={<TypeScriptBoardRegisterPage/>}/>
        </Routes>
      </Suspense>
    </div>
  )
}

export default MainRouter