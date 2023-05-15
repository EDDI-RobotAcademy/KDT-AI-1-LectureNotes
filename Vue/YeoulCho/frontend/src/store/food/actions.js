import axiosInst from '@/utility/axiosInst'

export default {
    requestCreateFoodToSpring ({ }, payload) {

        return axiosInst.post('/food-test/register', payload)
        .then((res)=>{
            alert('식재료등록성공 ')
            return res.data
        })
        .catch(()=>{
            alert('문제발생!')
        })
    }
}
