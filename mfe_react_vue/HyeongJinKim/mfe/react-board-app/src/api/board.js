import axios from "axios";

export const fetchBoardList = () => axios.get("http://localhost:7777/jpa-board/list");

export const registerBoard = (title, content, writer) =>
  axios.post("http://localhost:7777/jpa-board/register", { title, content, writer });
