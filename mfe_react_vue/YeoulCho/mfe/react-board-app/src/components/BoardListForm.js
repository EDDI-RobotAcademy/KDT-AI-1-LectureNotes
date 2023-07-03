import React from 'react' //rafce
import { Link } from 'react-router-dom' //imrr

const BoardListForm = ( { boards, isLoading } ) => {
  return (
    <div>
        <h2>React로 만든 게시판</h2>
        {isLoading && "로딩중.............."}
        {!isLoading && boards &&(
            <>
                <Link to="/react-board-app/register">글쓰기</Link>
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
                        { !boards.length ? (
                            <tr>
                                <td colspan={4}>
                                    등록된 게시물이 없습니다.
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