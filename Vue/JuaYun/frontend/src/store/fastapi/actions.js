import axiosInst from '@/utility/axiosInst'
import axios from 'axios'

export default {
    requestFirstIntegerToFastApiAfterSpring ({ }) {
        return axiosInst.get('/request-test/integer')       
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestSecondIntegerToFastApiAfterSpring ({ }) {
        return axiosInst.get('/fastapi-test/fastapi-integer-request')       
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestThirdIntegerToFastApiAfterSpring ({ }) {
        return axios.get('http://127.0.0.1:8000/request-int-prob')       
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}