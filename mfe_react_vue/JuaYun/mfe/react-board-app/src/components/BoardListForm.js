import React from 'react'
import { Link } from 'react-router-dom' // imrr

const BoardListForm = ({ boards, isLoading }) => {
  return (
    <div align="center">
      <h2>React로 만든 게시판</h2>
      { isLoading && "로딩중 ..........." }
      { !isLoading && boards && (
        <>
          <table border="1">
            <thead>
              <tr>
                <th align='center' width="80">
                  번호
                </th>
                <th align='center' width="320">
                  제목
                </th>
                <th align='center' width="100">
                  작성자
                </th>
                <th align='center' width="180">
                  등록일자
                </th>
              </tr>
            </thead>
            <tbody>
                {/* 삼항연산자 -> 조건 ? 참 : 거짓 */}
              { !boards.length ? (
                <tr>
                  <td colSpan={4}>
                    등록된 게시물이 존재하지 않습니다!
                  </td>
                </tr>
              ) : ( boards.map((board) => (
                <tr key={board.boardId}>
                  <td align="center">{ board.boardId }</td>
                  <td align="left">
                    {/* 가변인자 처리는 ``을 사용 */}
                    <Link to={`/react-board-app/read/${board.boardId}`}>{ board.title }</Link>
                  </td>
                  <td align="right">{ board.writer }</td>
                  <td align="center">{ board.createDate }</td>
                </tr>
              )))}
            </tbody>
          </table>
          <Link to="/react-board-app/register">글쓰기</Link>
        </>
      )}
    </div>
  )
}

export default BoardListForm