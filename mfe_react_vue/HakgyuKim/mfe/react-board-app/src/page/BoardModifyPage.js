import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardModifyForm from '../components/BoardModifyForm'

const BoardModifyPage = ({ history }) => {
  const { boardId } = useParams()

  const [board, setBoard] = useState(null)
  const [isLoading, setLoading] = useState(null)

  const navigate = useNavigate()

  const readBoard = async (boardId) => {
    setLoading(true)

    try {
        const response = await axiosClient.fetchBoard(boardId)
        setBoard(response.data)
        setLoading(false)
    } catch(e) {
        throw e
    }
  }


  const onModify = async (boardId, title, content, writer) => {
    try {
        const response = await axiosClient.modifyBoard(boardId, title, content, writer)

        alert('게시물 수정 성공!')

        navigate("/read/" + boardId)
    } catch (e) {
        console.log(e)
    }
  }

  useEffect(() => {
    readBoard(boardId)
  }, [boardId])

  return <BoardModifyForm board={board} isLoading={isLoading} onModify={onModify}/>
}

export default BoardModifyPage