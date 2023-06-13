import axios from "axios";

const axiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    timeout: 2500
})
// axios뒤에 붙이던 로컬 호스트를 기본으로 잡아주는 것

export default axiosInst