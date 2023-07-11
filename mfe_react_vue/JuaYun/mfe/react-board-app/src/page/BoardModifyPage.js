import React, { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import BoardModifyForm from '../components/BoardModifyForm'
import * as axiosClient from "../api/board"

const BoardModifyPage = ({ match, history }) => {
  const { boardId } = useParams()

  const [board, setBoard] = useState(null)
  const [isLoading, setLoading] = useState(false)

  const navigate = useNavigate()

  const onModify = async (boardId, title, content, writer) => {
    try {
      await axiosClient.modifyBoard(boardId, title, content, writer)
      alert('게시물이 성공적으로 수정되었습니다!')
      navigate("/react-board-app/read/" + boardId)
    } catch (e) {
      console.log(e)
    }
  }

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

  useEffect(() => {
    readBoard(boardId)
  }, [boardId])

  return (
    <BoardModifyForm board={board} isLoading={isLoading} onModify={onModify}/>
  )
}

export default BoardModifyPage