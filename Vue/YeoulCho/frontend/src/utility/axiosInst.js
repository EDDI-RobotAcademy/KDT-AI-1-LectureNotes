import axios from "axios"
//왜 axiosInst생성할까??
//axiosInst는 baseURL과 timeout을 가지고 있어서 코드를 쓸 때 사용하기 간편해짐
//baseURL 이후 경로만 작성해도 ok
//공통된 서버를 지정할 수 있다.
const axiosInst = axios.create({
    baseURL: 'http://localhost:7777', //api 주소
    timeout: 2500 
    //timeout: request에 대한 response의 시간 초과 설정,
    //응답 지연시 계속 기다리는 것을 방지
    //2.5초까지 기다리겠다.
})
// 신규 구성은 이 부분을 참고
// TODO: 추후 리팩토링을 진행해야 합니다 (우선순위 p3 ~ p4 정도)
const springAxiosInst = axiosInst

const fastApiAxiosInst = axios.create({
    baseURL: 'http://localhost:8000',
    timeout: 2500
})

export default { axiosInst, springAxiosInst, fastApiAxiosInst } //axios 인스턴스 생성 후 export