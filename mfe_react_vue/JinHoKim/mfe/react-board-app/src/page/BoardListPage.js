import React, { useState, useEffect } from 'react'
import BoardListForm from "../components/BoardListForm"
import * as axiosClient from "../api/board"

const BoardListPage = () => {
  const [boards, setBoards] = useState([])
  const [isLoading, setLoading] = useState(false)

  const listBoard = async () => {
    setLoading(true)
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
  useEffect (() => {
    listBoard()
  }, [])
  // [] 은 해당 페이지 접근할 때 딱 한 번만 동작하라는 의미

  // Vue props -> :boards="boards"
  return <BoardListForm boards={boards} isLoading={isLoading}/>
}

export default BoardListPage