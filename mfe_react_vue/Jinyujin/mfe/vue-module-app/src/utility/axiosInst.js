import axios from "axios";

const springAxiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    timeout: 2500
})

const fastApiAxiosInst = axios.create({
    baseURL: 'http://localhost:8000',
    timeout: 2500
})

export default {
    springAxiosInst,
    fastApiAxiosInst,
}
// axiosInst로 도메인이 변경되어도 유연한 대처 가능