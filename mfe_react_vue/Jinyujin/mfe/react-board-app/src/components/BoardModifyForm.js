import React, { useCallback, useEffect, useState } from 'react'
import { Link } from 'react-router-dom' // imrr

const BoardModifyForm = ({ board, isLoading, onModify }) => {
    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")

    const handleChangeTitle = useCallback((e) => {
        setTitle(e.target.value)
    }, [])
    const handleChangeContent = useCallback((e) => {
        setContent(e.target.value)
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();

        onModify(board.boardId, title, content, board.writer)
    }

    useEffect(() => {
        if (board) {
            setTitle(board.title)
            setContent(board.content)
        }
    }, [board])
    
    return (
        <div align="center">
            <h2>게시물 수정</h2>
            {isLoading && "로딩중 ..........."}
            {!isLoading && board && (
                <>
                <form onSubmit={handleSubmit}>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>번호</td>
                                <td>
                                    <input type="text" value={board.boardId} disabled/>
                                </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                                <td>
                                    <input type="text" value={title} onChange={handleChangeTitle} />
                                </td>
                        </tr>
                            <tr>
                                <td>작성자</td>
                                <td>
                                    <input type="text" defaultValue={board.writer} disabled />
                                </td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td>
                                    <textarea value={content} rows="5" onChange={handleChangeContent} />
                                </td>
                            </tr>
                    </tbody>
                </table>

                <div>
                    <button type="submit">수정</button>
                    <Link to={`/react-board-app/read/${board.boardId}`}>취소</Link>
                </div>
            </form>
        </>
        )}
        </div>
    )
}

export default BoardModifyForm