import {
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'
import router from '@/router'

export default {

    requestSomeDataToSpringWithUserToken ({ }, payload) {

        const { userToken, testNumber } = payload

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