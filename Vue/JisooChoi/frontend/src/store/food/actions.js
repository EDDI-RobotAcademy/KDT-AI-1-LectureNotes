// 커밋을 하는 게 아니기 때문에 mutation이 필요없다.

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