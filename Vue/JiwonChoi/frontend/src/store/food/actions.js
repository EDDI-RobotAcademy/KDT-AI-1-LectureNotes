import axiosInst from '@/utility/axiosInst'

export default {
    requestCreateFoodToSpring ({ }, payload) {

        return axiosInst.post('/food-test/register', payload)
                .then(() => {
                    alert('식재료 등록 성공')
                })
                .catch(() => {
                    alert('문제 발생!')
                })
    },
}