import axios from "axios";

// Legacy 구성은 아래를 참고
const axiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    //baseURL: 'http://192.168.20.3:7777',
    timeout: 2500
})
// 신규 구성은 이 부분을 참고
// TODO: 추후 리팩토링을 진행해야 합니다 (우선순위 p3 ~ p4 정도)
const springAxiosInst = axiosInst

const fastApiAxiosInst = axios.create({
    baseURL: 'http://localhost:8000',
    timeout: 2500
})

export default { axiosInst, springAxiosInst, fastApiAxiosInst }