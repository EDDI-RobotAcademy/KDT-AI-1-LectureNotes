import {
    REQUEST_HEALTH_DATA_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestHealthDataToSpring ({ commit }) {
        return axiosInst.get('/d3-test/get-health-info')
            .then((res) => {
                commit(REQUEST_HEALTH_DATA_TO_SPRING, res.data)
                return res.data
            })
    },
    requestOtherHealthDataToSpring ({ commit }) {
        return axiosInst.get('/d3-test/get-other-health-info')
            .then((res) => {
                return res.data
            })
    }
}