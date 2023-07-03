import React, { forwardRef } from 'react'
import { useNavigate } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardRegisterForm from '../components/BoardRegisterForm'

const BoardRegisterPage = forwardRef((props, reactContainerRef) => {
  console.log('reactContainerRef: ' + reactContainerRef)
  // Vue에서 $router.push() 같은 역할
  const navigate = useNavigate()

  const onRegister = async (title, content, writer) => {
    try {
        const response = await axiosClient.registerBoard(title, content, writer)

        alert('게시물 등록 성공!')

        console.log(response.data.boardId)
        navigate("/react-board-app/read/" + response.data.boardId)
    } catch (e) {
        console.log(e)
    }
  }

  // Vue에서 onSubmit 같은 녀석, emit으로 Event 받아오는 것과 유사함
  // props인지 emit인지 구별이 잘 안되서 혼선을 유발하므로 주의가 필요함
    return (
        <div ref={reactContainerRef}>
            <BoardRegisterForm onRegister={onRegister}/>
        </div>
    );
})

export default BoardRegisterPage