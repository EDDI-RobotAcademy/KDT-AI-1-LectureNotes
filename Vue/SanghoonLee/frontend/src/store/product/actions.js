import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestProductListToSpring ({ commit }) {
        axiosInst.get('/jpa-product/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
            })
    },
    requestRegisterProductToSpring ({}, payload) {

        const { productName, price } = payload

        return axiosInst.post('/jpa-product/register', { productName, price })
            .then((res) => {
                alert('상품 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}