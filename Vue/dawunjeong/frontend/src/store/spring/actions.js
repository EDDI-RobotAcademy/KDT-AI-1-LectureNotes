import {
    REQUEST_INTEGER_TO_SPRING,
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {
    requestIntegerToSpring ({ commit }) {
        return axiosInstances.springAxiosInst.get('/integer-request')
            .then((res) => {
                commit(REQUEST_INTEGER_TO_SPRING, res.data)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}