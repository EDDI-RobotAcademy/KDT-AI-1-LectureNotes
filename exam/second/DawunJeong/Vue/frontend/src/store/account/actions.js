import axiosInst from '@/utility/axiosInst'

export default {
    requestNormalCreateAccountToSpring ({ }, payload) {

        return axiosInst.post('/account/normal-register', payload)
                .then((res) => {
                    alert('회원 가입 성공')
                })
                .catch(() => {
                    alert('문제 발생!')
                })
    },
    requestBusinessCreateAccountToSpring ({ }, payload) {

        return axiosInst.post('/account/business-register', payload)
                .then((res) => {
                    alert('회원 가입 성공')
                })
                .catch(() => {
                    alert('문제 발생!')
                })
    },
    requestLoginAccountToSpring ({ }, payload) {

        return axiosInst.post('/account/login', payload)
                .then((res) => {
                    alert('로그인 성공')
                    console.log("res.data: " + JSON.stringify(res.data))
                    localStorage.setItem("userToken", res.data)
                })
    },
}