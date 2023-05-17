import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterMemberToSpring ({}, payload) {
        const {name,email,password,roleType,businessNumber}=payload
        console.log("name: " + name + ", roleType: " + roleType + 
        ", email: " + email + ", businessNumber: " + businessNumber)
        return axiosInst.post('/member/register',{name,email,password,roleType,businessNumber})
            .then((res) => {
                alert('요청 성공!')
                console.log(res.data)
                return res
                
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },

    requestLoginToSpring ({}, payload) {
        const {email,password}=payload
        axiosInst.post('/test20/login',{email,password})
            .then((res) => {
                if (res.data ==null) {
                    alert('로그인 실패!')   
                } else {
                    alert('로그인 완료!')
                    this.accountId = res.data.id
                    console.log('accountId: ' + this.accountId)
                    localStorage.setItem("loginUserInfo", res.data.id)
                }
    })
}
}