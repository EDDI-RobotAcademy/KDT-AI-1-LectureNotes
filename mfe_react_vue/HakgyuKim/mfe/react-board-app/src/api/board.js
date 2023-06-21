import axios from "axios"

export const fetchBoardList = () => axios.get("http://localhost:7777/jpa-board/list")