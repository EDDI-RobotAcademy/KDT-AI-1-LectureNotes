import {
    GITHUB_LOGIN_COMPLETE
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {
    /*
        Github Oauth Apps에 있는 client_id를 넣어서 URL 요청하려고
        주소값을 String으로 받아오는 부분
    */
    requestGithubLoginToSpring ({ }) {
        return axiosInstances.springAxiosInst.get('/authentication/github/login')
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert("문제 발생!")
            })
    },
    getAccessTokenFromSpringRedirection ({ commit }, payload) {
        const { code } = payload
    
        axiosInstances.springAxiosInst.get(`/authentication/github/oauth-code?code=${code}`)
            .then((res) => {
                 //alert("res: " + JSON.stringify(res.data))
                 localStorage.setItem("userToken", res.data)
                 commit(GITHUB_LOGIN_COMPLETE, true)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}