import {
    REQUEST_MOMENTUM_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestMomentumToSpring({ commit }) {
        return axiosInst.get('/d3plot/get')
            .then((res) => {
                commit(REQUEST_MOMENTUM_TO_SPRING, res.data)
                console.log(res)
            })
    }
}