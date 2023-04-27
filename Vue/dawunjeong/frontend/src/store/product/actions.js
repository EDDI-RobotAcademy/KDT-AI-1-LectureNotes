import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterProductToSpring ({}, payload) {
        const { name, details, price, file } = payload

        return axiosInst.post('/jpa-product/register', { name, details, price, file })
            .then((res) => {
                alert('상품 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestProductListToSpring ({ commit }) {
        return axiosInst.get('/jpa-product/list')
            .then((res) => {
                commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
            })
            .catch(() => {
                alert('되겠냐')
            })
    },
}
