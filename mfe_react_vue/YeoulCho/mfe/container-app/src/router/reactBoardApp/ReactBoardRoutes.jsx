import React, { Suspense } from 'react'
import { Routes,Route } from 'react-router-dom'

import BoardListPage from 'reactBoardApp/BoardListPage'
import BoardModifyPage from 'reactBoardApp/BoardModifyPage'
import BoardReadPage from 'reactBoardApp/BoardReadPage'
import BoardRegisterPage from 'reactBoardApp/BoardRegisterPage'

const ReactBaordRoutes = () => {
  return (
    <div>
        <div style={{ position: 'relative' }}>
          <Suspense fallback={<div>로딩중..........</div>}>
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

export default ReactBaordRoutes