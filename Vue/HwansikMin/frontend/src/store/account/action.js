import {
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {
    requestSpringToCheckEmailDuplication ({}, payload) {
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
    requestCreateBoardToSpring ({}, payload) {

        const { title, content, writer } = payload

        return axiosInst.post('/jpa-board/register', { title, content, writer })
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}