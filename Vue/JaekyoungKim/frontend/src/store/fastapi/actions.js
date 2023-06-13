import {
    REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestIntegerToFastApiAfterSpring ({ commit }) {
        return axiosInst.get('/fastapi-test/fastapi-integer-request')
            .then((res) => {
                commit(REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING, res.data)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}