import {
    REQUEST_IMAGE_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestImageToSpring({ commit }) {
        return axiosInst.get('/images/get')
            .then((res) => {
                commit(REQUEST_IMAGE_TO_SPRING, res.data)
                return res.data
            })
    },
}