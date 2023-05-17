import {
    REQUEST_TEST_HEALTH_DATA_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestHealthDataToSpring ({ commit }) {
        return axiosInst.get('/d3-test/get-health-info')
            .then((res) => {
                commit(REQUEST_TEST_HEALTH_DATA_TO_SPRING, res.data)
                return res.data
            })
    },
}