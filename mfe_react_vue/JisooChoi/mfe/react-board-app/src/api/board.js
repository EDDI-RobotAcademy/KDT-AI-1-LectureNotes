import axios from "axios"

export const fetchBoardList = () => axios.get("http://localhost:7777/jpa-board/list")

export const registerBoard = (title, content, writer) => 
    axios.post("http://localhost:7777/jpa-board/register", { title, content, writer })

export const fetchBoard = (boardId) => axios.get(`http://localhost:7777/jpa-board/${boardId}`)

export const removeBoard = (boardId) => axios.delete(`http://localhost:7777/jpa-board/${boardId}`)

export const modifyBoard = (boardId, title, content, writer) => 
    axios.put(`http://localhost:7777/jpa-board/${boardId}`, { title, content, writer })