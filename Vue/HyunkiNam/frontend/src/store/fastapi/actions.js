import axios from 'axios'
import {
    REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING,

} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestIntegerToFastApiAfterSpring({ commit }) {
        return axiosInst.get('/fastapi-test/fastapi-integer-request')
            .then((res) => {
                commit(REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING, res.data)
                return res.data
                alert(res.data)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    },
    requestIntegerToSpring({ }) {
        return axiosInst.get('/fastapi-test/getInteger')
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    },
    requestIntegerToFastAPI({ }) {
        return axios.get("http://localhost:8000/request-int-data-to-vue")
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}