import React, { Suspense } from 'react'
import { Routes, Route } from 'react-router-dom'

import BoardListPage from 'reactBoardApp/BoardListPage'
import BoardRegisterPage from 'reactBoardApp/BoardRegisterPage'
import BoardReadPage from 'reactBoardApp/BoardReadPage'
import BoardModifyPage from 'reactBoardApp/BoardModifyPage'

const ReactBoardRoutes = () => {
  return (
    <div>
      <div style={{ position: 'relative' }}>
        <Suspense fallback={<div>로딩중</div>}>
          <Routes>
            <Route path="/react-board-app" element={<BoardListPage/>}/>
            <Route path="/react-board-app/register" element={<BoardRegisterPage/>}/>
            <Route path="/react-board-app/read/:boardId" element={<BoardReadPage/>}/>
            <Route path="/react-board-app/modify/:boardId" element={<BoardModifyPage/>}/>
          </Routes>
        </Suspense>
      </div>
    </div>
  )
}

export default ReactBoardRoutes