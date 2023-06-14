import {
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {
    requestSpringToCheckEmailDuplication ({ }, payload) {
        const { email } = payload
        console.log('email: ' + email)

        return axiosInstances.springAxiosInst.get(`/account/check-email/${email}`)
            .then((res) => {
                if (res.data) {
                    alert('사용 가능한 이메일입니다!')
                    return true
                } else {
                    alert('중복된 이메일입니다!')
                    return false
                }
            })
            .catch((res) => {
                alert("문제 발생!")
            })
    },
    requestRegisterAccountToSpring ({ }, payload) {

        const { email } = payload

        return axiosInstances.springAxiosInst.post('/account/sign-up', { email })
            .then((res) => {
                alert('회원 신청하기 성공!')
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}