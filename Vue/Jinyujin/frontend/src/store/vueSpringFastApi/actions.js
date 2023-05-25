import axiosInst from '@/utility/axiosInst'
import axios from 'axios'

export default {
    requestfirstNumberToSpring({ }) {
        return axiosInst.get('/vue-spring/first-number')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestSecondNumberToSpring({ }) {
        return axiosInst.get('/vue-spring/second-number')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestThirdNumberToSpring({ }) {
        return axios.get('http://localhost:8000/request_third_number')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}