import React from 'react'
import { Link } from 'react-router-dom' // imrr

const BoardReadForm = ({ boardId, board, isLoading, onRemove }) => {
  return (
      <div align="center">
        <h2>상세 보기</h2>
          {isLoading && "로딩중 ..........."}
          {!isLoading && board && (
              <>
                  <table border="1">
                      <tbody>
                          <tr>
                              <td>번호</td>
                              <td>
                                  <input type="text" value={board.boardId} readonly />
                              </td>
                          </tr>
                          <tr>
                              <td>제목</td>
                              <td>
                                  <input type="text" value={board.title} readonly />
                              </td>
                          </tr>
                          <tr>
                              <td>작성자</td>
                              <td>
                                  <input type="text" value={board.writer} readonly />
                              </td>
                          </tr>
                          <tr>
                              <td>내용</td>
                              <td>
                                  <textarea value={board.content} readonly />
                              </td>
                          </tr>
                      </tbody>
                  </table>

                  <Link to={`/react-board-app/modify/${boardId}`}>수정</Link>
                  <button onClick={onRemove}>삭제</button>
                  <Link to="/react-board-app">돌아가기</Link>
              </>
          )}
    </div>
  )
}

export default BoardReadForm