import React, { useEffect } from 'react'
import { Route, Routes } from 'react-router-dom'
import { QueryClient, QueryClientProvider  } from 'react-query'

import TypescriptBoardListPage from 'reactQueryZustandMuiTypescriptBoardApp/TypescriptBoardListPage'

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
            <Route path="/react-query-zustand-mui-typescript-board-app" element={<TypescriptBoardListPage/>} />
            {/* <Route path="/react-board-app/register" element={<BoardRegisterPage/>} />
            <Route path="/react-board-app/read/:boardId" element={<BoardReadPage/>} />
            <Route path="/react-board-app/modify/:boardId" element={<BoardModifyPage/>} /> */}
          </Routes>
        </QueryClientProvider>
      </div>
    </div>
  )
}

export default ReactTypescriptMuiBoardRoutes