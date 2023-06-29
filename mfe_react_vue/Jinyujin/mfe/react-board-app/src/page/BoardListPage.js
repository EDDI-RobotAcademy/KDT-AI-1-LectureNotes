// rafce
import React, { useEffect, useState } from 'react'
// useEffect: 컴포넌트가 렌더링될 때마다 특정 동작을 수행할 수 있도록 설정
// useState: 상태 관리
import BoardListForm from '../components/BoardListForm'
import * as axiosClient from "../api/board"
// axios 연결
// axiosClient 모듈에서 fetchBoardList 함수를 가져와 연결해줌

const BoardListPage = () => {
    const [boards, setBoards] = useState([]) // useState([]): 초기값 설정 - 빈 배열이라는 뜻
    // boards는 상태 변수, setBoards는 상태를 업데이트 하는 변수
    // boards의 상태가 변화하는걸 setBoards에 담아서 나타냄
    const [isLoading, setLoading] = useState([])

    const listBoard = async () => {
        setLoading(true)
        // isLoading 상태를 true로 설정

        try {
            const response = await axiosClient.fetchBoardList()

            setBoards(response.data)

            setLoading(false)
        } catch (e) {
            setLoading(false)
            throw e
        }
    }

    // 변경이 발생하면 반응
    useEffect(() => {
        listBoard()
    }, [])
    // []은 해당 페이지 접근할 때 딱 한 번만 동작하라는 의미

    // :boards="boards" vue에서 컴포넌트 전달할 때와 같은 표현
    return <BoardListForm boards={boards} isLoading={isLoading} />
}

export default BoardListPage