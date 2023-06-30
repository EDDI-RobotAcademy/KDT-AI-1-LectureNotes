import React, { useEffect } from 'react'
import { Route, Routes } from 'react-router-dom'
import { QueryClient, QueryClientProvider  } from 'react-query'

import TypescriptBoardListPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardListPage'
import TypescriptBoardRegisterPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardRegisterPage'
import TypescriptBoardReadPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardReadPage'
import TypescriptBoardModifyPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardModifyPage'

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      retry: false,
      staleTime: 30000,
    }
  }
})

const ReactTypescriptMuiBoardRoutes = () => {
  return (
    <div>
      <div style={{ position: 'relative' }}>
      <QueryClientProvider client={queryClient}>
          <Routes>
            <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage/>} />
            <Route path="/react-board-app/register" element={<TypescriptBoardRegisterPage/>} />
            <Route path="/react-board-app/read/:boardId" element={<TypescriptBoardReadPage/>} />
            <Route path="/react-board-app/modify/:boardId" element={<TypescriptBoardModifyPage/>} />
          </Routes>
        </QueryClientProvider>
      </div>
    </div>
  )
}

export default ReactTypescriptMuiBoardRoutes