import React, { Suspense } from 'react'
import { Route, Routes } from 'react-router-dom'

import BoardListPage from 'reactBoardApp/BoardListPage';
import BoardRegisterPage from 'reactBoardApp/BoardRegisterPage';
import BoardReadPage from 'reactBoardApp/BoardReadPage';
import BoardModifyPage from 'reactBoardApp/BoardModifyPage';

const ReactBoardRoutes = () => {
  return (
    <div style={{position: 'relative'}}>
      <div>
        <Suspense fallback={<div>로딩중 .........</div>}>
          <Routes>
            <Route element={<BoardListPage/>} path="/react-board-app"/>
            <Route element={<BoardRegisterPage/>} path="/react-board-app/register"></Route>
            <Route element={<BoardReadPage/>} path="/react-board-app/read/:boardId"></Route>
            <Route element={<BoardModifyPage/>} path="/react-board-app/modify/:boardId"></Route>
          </Routes>
        </Suspense>
      </div>
    </div>
  )
}

export default ReactBoardRoutes