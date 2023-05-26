
import axiosInst from '@/utility/axiosInst'

export default{
requestCreateProductToSpring ({ }, payload) {

    return axiosInst.post('/product-test/register', payload)
            .then(() => {
                alert('상품 등록 성공')
            })
            .catch(() => {
                alert('문제 발생!')
            })
},
}