import {
    GITHUB_LOGIN_COMPLETE,
} from './mutation-types'

import axiosInst from '../../utility/axiosInst'

export default {
    requestGithubLoginToSpring ({ }) {
        return axiosInst.springAxiosInst.get('/authentication/github/login')
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert("문제 발생!")
            })
    },
    getAccessTokenFromSpringRedirection ({ commit }, payload) {
        console.log('getAccessTokenFromSpringRedirection()')
        const { code } = payload

        axiosInst.springAxiosInst.get(`/authentication/github/oauth-code?code=${code}`)
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