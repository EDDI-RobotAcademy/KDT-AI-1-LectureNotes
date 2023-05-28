import axios from "axios";

const axiosInst = axios.create({
    baseURL: 'http://localhost:7778',
    timeout: 2500
})

export default axiosInst