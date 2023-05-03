import axios from "axios";

const axiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    timeout: 2500
})

export default axiosInst
// axiosInst로 도메인이 변경되어도 유연한 대처 가능