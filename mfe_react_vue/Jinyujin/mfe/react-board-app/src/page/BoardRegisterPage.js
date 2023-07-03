import React from 'react'

// axios 요청, 등록하면 리드 페이지로 넘어가게
import { useNavigate } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardRegisterForm from '../components/BoardRegisterForm'

const BoardRegisterPage = ({ history }) => {
    // Vue에서 $router.push()와 같은 역할
    const navigate = useNavigate()

    const onRegister = async (title, content, writer) => {
        try {
            const response = await axiosClient.registerBoard(title, content, writer)

            alert('게시물 등록 성공!')

            console.log(response.data.boardId)
            navigate("/react-board-app/read/" + response.data.boardId)
            // 처음에 /read 이렇게 써서 제대로 창이 안나왔음
            // /read/ 꼭 이렇게 잘 써줄 것!
            // 뒤에 가변인자가 붙기 때문임
        } catch (e) {
            console.log(e)
        }
    }
  
    // Vue에서 onSubmit 같은 녀석 emit으로 event 받아오는 것과 유사함
    // props인지 emit인지 구별이 잘 안돼서 혼선을 유발하므로 주의가 필요함
    return <BoardRegisterForm onRegister={onRegister}/>
}

export default BoardRegisterPage