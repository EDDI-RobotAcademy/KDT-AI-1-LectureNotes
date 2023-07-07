import React, { Suspense } from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import TypeScriptBoardListPage from '../page/TypeScriptBoardListPage'
import TypeScriptBoardRegisterPage from '../page/TypeScriptBoardRegisterPage'
import TypeScriptBoardReadPage from '../page/TypeScriptBoardReadPage'
import TypeScriptBoardModifyPage from '../page/TypeScriptBoardModifyPage'

const MainRouter = () => {
  return (
    <div>
      <Suspense fallback={<div>로딩중</div>}>
        <Routes>
          <Route path="/" element={<Navigate to="/react-query-zustand-mui-typescript-board-app" replace/>}/>
          <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypeScriptBoardListPage/>}/>
          <Route path="/react-query-zustand-mui-typescript-board-app/register" element={<TypeScriptBoardRegisterPage/>}/>
          <Route path="/react-query-zustand-mui-typescript-board-app/read/:boardId" element={<TypeScriptBoardReadPage/>}/>
          <Route path="/react-query-zustand-mui-typescript-board-app/modify/:boardId" element={<TypeScriptBoardModifyPage/>}/>
        </Routes>
      </Suspense>
    </div>
  )
}

export default MainRouter