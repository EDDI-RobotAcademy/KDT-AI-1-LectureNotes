import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterProductToSpring ({}, payload) {
        const { name, price, manufacturer, expirationDate, productionDate, details } = payload

        return axiosInst.post('/jpa-product/register', 
        { name, price, manufacturer,  expirationDate, productionDate, details })
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
    requestProductToSpring ({ commit }, productId) {
        return axiosInst.get(`/jpa-product/${productId}`)
            .then((res) => {
                commit(REQUEST_PRODUCT_TO_SPRING, res.data)
            })
    },
    requestDeleteProductToSpring ({}, productId) {
        return axiosInst.delete(`/jpa-product/${productId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}
