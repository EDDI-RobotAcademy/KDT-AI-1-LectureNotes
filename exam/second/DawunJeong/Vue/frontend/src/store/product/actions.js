import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestCreateProductToSpring ({ }, payload) {

        return axiosInst.post('/product/register', payload)
                .then((res) => {
                    console.log("res.data: " + JSON.stringify(res.data))
                })
    },
    requestProductListToSpring ({ commit }) {
        return axiosInst.get('/product/list')
            .then((res) => {
                console.log("뭐지!!!")
                commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
            })
    },
    requestProductToSpring ({ commit }, id) {
        return axiosInst.get(`/product/${id}`)
            .then((res) => {
                commit(REQUEST_PRODUCT_TO_SPRING, res.data)
            })
    },
}