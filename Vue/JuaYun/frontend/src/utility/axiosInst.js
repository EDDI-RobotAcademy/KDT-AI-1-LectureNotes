import axios from "axios";

const axiosInst = axios.create({
    baseURL: 'http://localhost:7777',
    timeout: 2500
})
const springAxiosInst = axiosInst

const fastApiAxiosInst = axios.create({
    baseURL: 'http://localhost:8000',
    timeout: 2500
})

export default { axiosInst, springAxiosInst, fastApiAxiosInst }