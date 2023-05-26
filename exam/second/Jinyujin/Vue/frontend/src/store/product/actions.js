import axiosInst from '@/utility/axiosInst'

export default {
    requestCreateProductToSpring({ }, payload) {

        return axiosInst.post('/problem24/product-register', payload)
            .then(() => {
                alert('상품 등록 성공')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}