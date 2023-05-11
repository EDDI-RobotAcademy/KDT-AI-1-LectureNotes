import {
    REQUEST_HEALTH_PROB_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestHealthProbToSpring ({ commit }){
        return axiosInst.get('/d3-test/health-data-prob')
        .then((res) => {
            commit(REQUEST_HEALTH_PROB_TO_SPRING, res.data)
            return res.data
        })
    }
}