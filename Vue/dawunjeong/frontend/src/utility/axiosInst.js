import axios from "axios";

/*
baseURL을 지정해줌으로써 경로를 지정할 때 baseURL 이후의 경로만 작성할 수 있게 됩니다.
timeout을 2500으로 설정한 것은 모든 요청이 최대 2.5초 동안 실행될 수 있다는 것을 의미합니다.
응답이 지연되는 경우 계속해서 기다리는 것을 방지하기 위해 timeout을 설정해줍니다.
*/

// Legacy 구성은 아래를 참고
const axiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    // baseURL: 'http://192.168.20.3:7777',
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