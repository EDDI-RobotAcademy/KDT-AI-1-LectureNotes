import {
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {

    requestSomeDataToSpringWithUserToken({ }, payload) {
        // userToken을 가지고 Spring에 뭔가를 요청한다

        const { userToken, testNumber } = payload
        // 스프링 requestForm에 맞춰서
        console.log('userToken: ' + userToken + 'testNumber: ' + testNumber)
        
        return axiosInstances.springAxiosInst.post('/after-login/test',
            { userToken, testNumber })
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert("문제 발생!")
            })
    },
}