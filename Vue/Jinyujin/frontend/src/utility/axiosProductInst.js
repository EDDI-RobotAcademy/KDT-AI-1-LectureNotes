import axios from "axios";

const axiosProductInst = axios.create({
    baseURL: 'http://localhost:5555',
    timeout: 2500
})

export default axiosProductInst