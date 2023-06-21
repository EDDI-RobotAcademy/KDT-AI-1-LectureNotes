import React from 'react'
import { Link } from 'react-router-dom' // imrr


const BoardListPage = ({ boards, isLoding }) => {
  return (
    <div>
      <h2>React로 만든 게시판</h2>
      { isLoding && "로딩중 ........."}
      {!isLoding && boards && (
        <>
         <Link to="/register">글쓰기</Link>
          <table border="1">
            <thead>
              <tr>
                <th align="center" width="80">
                  번호
                </th>
                <th align="center" width="320">
                  제목
                </th>
                <th align="center" width="100">
                  작성자
                </th>
                <th align="center" width="180">
                  등록일자
                </th>
              </tr>
            </thead>
            <tbody>
              {!boards.length && (
                <tr>
                  <td colSpan={4}>
                    등록된 게시물이 존재하지 않습니다!
                  </td>
                </tr>
              )}
              {!!boards.length && boards.map((board) => {
                <tr key={board.boardId}>
                  <td align="center">{ board.boardId }</td>
                  <td align="left">
                    { board.title }
                  </td>
                  <td align='right'>{ board.writer }</td>
                  <td align='center'>{ board.createDate }</td>
                </tr>
              })}
            </tbody>
         </table>
        </>
      )}
    </div>
  )
}

export default BoardListPage