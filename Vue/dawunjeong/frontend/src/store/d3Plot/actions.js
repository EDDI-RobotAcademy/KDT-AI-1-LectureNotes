import {
    REQUEST_HEALTHDATA_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestHealthDataListToSpring ({ commit }) {
        return axiosInst.get('/give-me/healthData')
            .then((res) => {
                commit(REQUEST_HEALTHDATA_TO_SPRING, res.data)
                return res.data
            })
    },
}