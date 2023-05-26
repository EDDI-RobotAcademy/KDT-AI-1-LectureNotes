import {
    REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING,
    REQUEST_INTEGER_TO_FASTAPI,
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {
    requestIntegerToFastApiAfterSpring ({ commit }) {
        return axiosInstances.springAxiosInst.get('/fastapi-test/fastapi-integer-request')
            .then((res) => {
                commit(REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING, res.data)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    },
    requestIntegerToFastApi ({ commit }) {
        return axiosInstances.fastApiAxiosInst.get('/integer-request')
            .then((res) => {
                commit(REQUEST_INTEGER_TO_FASTAPI, res.data)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}