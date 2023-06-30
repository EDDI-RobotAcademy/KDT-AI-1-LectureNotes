import React, { Suspense } from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import TypescriptBoardListPage from '../page/TypescriptBoardListPage'
import TypescriptBoardRegisterPage from '../page/TypescriptBoardRegisterPage'

const MainRouter = () => {
    return (
        <>
            <Suspense fallback={<div>로딩중 ........</div>}>
                <Routes>
                    <Route path="/" element={<Navigate to="/react-query-zustand-mui-typescript-board-app" replace />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage />} />
                    <Route path="/react-query-zustand-mui-typescript-board-app/register" element={<TypescriptBoardRegisterPage />} />
                </Routes>
            </Suspense>
        </>
    )
}

export default MainRouter