import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardReadForm from "../components/BoardReadForm"

// Vue와 다르게 React는 화면을 출력하는 영역과 이에 대한 처리 로직이 존재하는 영역이 공존
// 이것때문에 사실상 관심사의 분리 측면에서 다소 어지러운 면이 존재함

// 그럼 왜 이런 것을 현업에서 여전히 사용하는가?
// => 시장 진입을 먼저 했기 때문
const BoardReadPage = () => {
    const { boardId } = useParams()
    const [board, setBoard] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const readBoard = async (boardId) => {
        setLoading(true)

        try {
            const response = await axiosClient.fetchBoard(boardId)
            setBoard(response.data)
            setLoading(false)
        } catch (e) {
            throw e
        }
    }

    const onRemove = async () => {
        try {
            await axiosClient.removeBoard(boardId)
            alert('게시물 삭제')
            navigate("/")
        } catch (e) {
            console.log(e)
        }
    }

    useEffect(() => {
        readBoard(boardId)
    }, [boardId])

    return <BoardReadForm boardId={boardId} board={board} isLoading={isLoading} onRemove={onRemove} />
}

export default BoardReadPage