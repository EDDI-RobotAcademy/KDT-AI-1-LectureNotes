import {
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {

    requestSomeDataToSpringWithUserToken ({ }, payload) {

        const { userToken, testNumber } = payload
        console.log('userToken: ' + userToken + ', testNumber: ' + testNumber)

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