import React, { useEffect } from 'react'
import { Route, Routes } from 'react-router-dom'
import { QueryClient, QueryClientProvider } from 'react-query'

import TypescriptBoardListPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardListPage'
import TypescriptBoardModifyPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardModifyPage'
import TypescriptBoardReadPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardReadPage'
import TypescriptBoardRegisterPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardRegisterPage'

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            refetchOnWindowFocus: false,
            retry: false,
            staleTime: 30000,
        }
    }
})

const ReactTypescriptMuiBoardRoutes = ({ naviHeight }) => {
    useEffect(() => {
        const contentWrapper = document.getElementById('content-wrapper')
        if (contentWrapper && naviHeight) {
            const marginTop = (naviHeight + 20) + 'px'
            contentWrapper.style.marginTop = marginTop
        }
    })

    return (
        <div>
            <div di="content-wrapper" style={{ position: 'relative' }}>
                <QueryClientProvider client={queryClient}>
                    <Routes>
                        <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage />} />
                        <Route path="/react-query-zustand-mui-typescript-board-app/register" element={<TypescriptBoardRegisterPage />} />
                        <Route path="/react-query-zustand-mui-typescript-board-app/read/:boardId" element={<TypescriptBoardReadPage />} />
                        <Route path="/react-query-zustand-mui-typescript-board-app/modify/:boardId" element={<TypescriptBoardModifyPage />} />
                    </Routes>
                </QueryClientProvider>
            </div>
        </div>
    )
}

export default ReactTypescriptMuiBoardRoutes