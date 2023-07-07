import React, { Suspense } from 'react'
import { Route, Routes } from 'react-router-dom'

import BoardListPage from 'reactBoardApp/BoardListPage'
import BoardRegisterPage from 'reactBoardApp/BoardRegisterPage'
import BoardReadPage from 'reactBoardApp/BoardReadPage'
import BoardModifyPage from 'reactBoardApp/BoardModifyPage'

const ReactBoardRoutes = ({ containerModuleRef }) => {
  return (
    <div>
      <div style={{ position: 'relative' }}>
        <Suspense fallback={<div>로딩중 ........</div>}>
          <Routes>
            <Route path="/react-board-app" element={<BoardListPage ref={containerModuleRef}/>} />
            <Route path="/react-board-app/register" element={<BoardRegisterPage ref={containerModuleRef}/>} />
            <Route path="/react-board-app/read/:boardId" element={<BoardReadPage ref={containerModuleRef}/>} />
            <Route path="/react-board-app/modify/:boardId" element={<BoardModifyPage ref={containerModuleRef}/>} />
          </Routes>
        </Suspense>
      </div>
    </div>
  )
}

export default ReactBoardRoutes