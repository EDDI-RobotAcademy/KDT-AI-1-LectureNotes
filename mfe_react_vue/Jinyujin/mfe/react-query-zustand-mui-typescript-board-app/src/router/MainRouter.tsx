import React, { Suspense } from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import TypescriptBoardListPage from '../page/TypescriptBoardListPage'
import TypescriptBoardRegisterPage from '../page/TypescriptBoardRegisterPage'
import TypescriptBoardReadPage from '../page/TypescriptBoardReadPage'
import TypescriptBoardModifyPage from '../page/TypescriptBoardModifyPage'

const MainRouter = () => {
    return (
        <>
            <Suspense fallback={<div>로딩중 ........</div>}>
                <Routes>
                    <Route path="/" element={<Navigate to="/react-query-zustand-mui-typescript-board-app" replace />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app/register" element={<TypescriptBoardRegisterPage />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app/read/:boardId" element={<TypescriptBoardReadPage />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app/modify/:boardId" element={<TypescriptBoardModifyPage />} />
                </Routes>
            </Suspense>
        </>
    )
}

export default MainRouter