import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardReadForm from '../components/BoardReadForm'

// Vue와 다르게 React는 화면을 출력하는 영역과 이에 대한 처리 로직이 존재하는 영역이 공존하고 있음
// 이것 때문에 사실상 관심사의 분리 측면에서 다소 어지러운 측면이 존재함 (그러나 사람은 적응의 동물이다)

// 그럼 왜 이런 것을 여전히 현업에서 사용하고 있는가?
// 시잔 진입을 먼저 했기 때문(관성)입니다 -> 왜 아직도 SI는 JSP를 쓰나요? 와 같은 질문
const BoardReadPage = () => { //BoardReadPage() 이 자체가 함수
    const { boardId } = useParams()
    // vue에서는 props 설정해서 default로 전달되도록 했는데
    // 여기서는 useParams()를 써줘야 함
    // vue에서는 이게 methods 부분에

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

    useEffect(() => { // 리드페이지 효과
        readBoard(boardId)
    }, [boardId])

    // 삭제
    // onRemove는 삭제 눌렀을 때의 트리거
    const onRemove = async () => {
        try {
            await axiosClient.removeBoard(boardId)
            alert('게시물이 삭제되었습니다')
            navigate("/react-board-app")
        } catch (e) {
            console.log(e)
        }
    }

    return ( // vue에서는 이게 template에
      // 어쨋거나 관심사의 분리는 잘 되어있음
        <BoardReadForm boardId={boardId} board={board} isLoading={isLoading} onRemove={onRemove}/>
  )
}

export default BoardReadPage