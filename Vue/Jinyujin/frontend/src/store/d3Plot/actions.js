import {
    REQUEST_HEALTH_DATA_TO_SPRING,
    // REQUEST_HEALTH_AMOUNT_TO_SPRING,
    // REQUEST_HEALTH_DATE_TO_SPRING
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestHealthDataToSpring({ commit }) {
        return axiosInst.get('/give-me/health-data')
            .then((res) => {
                commit(REQUEST_HEALTH_DATA_TO_SPRING, res.data)
                // commit(REQUEST_HEALTH_AMOUNT_TO_SPRING, res.data.healthAmount)
                // commit(REQUEST_HEALTH_DATE_TO_SPRING, res.data.date)
                return res.data
            })
    },
}