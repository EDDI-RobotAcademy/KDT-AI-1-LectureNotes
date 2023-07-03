import React from 'react'
import { Link } from 'react-router-dom' // imrr

// props로 받는 정보가 {boards, isLoading}
const BoardListForm = ({boards, isLoading}) => {
    return (
      <div align="center">
        <h2>React로 만든 게시판</h2>
        { isLoading && "로딩중 ..........." }
        { !isLoading && boards && (
          <>
            <Link to="/react-board-app/register">글쓰기</Link>
            {/* 라우터는 App에 만들어줌 */}
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
                    {/* 
                        삼항 연산자 = 조건 ? a : b 
                        버그가 있어서 이걸 만들어줬는데
                        나는 버그가 없었음;;
                    */}
                    {!boards.length ? (
                        <tr>
                            <td colSpan={4}>
                                등록된 게시물이 존재하지 않습니다!
                            </td>
                        </tr>
                            ) : (boards.map((board) => (
                        <tr key={board.boardId}>
                            <td align="center">{board.boardId}</td>
                                <td align="left">
                                  <Link to={`/react-board-app/read/${board.boardId}`}>{board.title}</Link>
                                </td>
                            <td align="right">{board.writer}</td>
                            <td align="center">{board.createDate}</td>
                        </tr>
                    )))}
                </tbody>
            </table>
        </>
    )}
    </div>
  )
}

export default BoardListForm