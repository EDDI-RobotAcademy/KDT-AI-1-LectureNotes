import {
    GITHUB_LOGIN_COMPLETE
} from './mutation-types'

import axiosInstances from '@/utility/axiosInst'

export default {

    requestGithubLoginToSpring ({ }) {

        return axiosInstances.springAxiosInst.get('/authentication/github/login')
            .then((res) => {
                return res.data
            })
    },
    getAccessTokenFromSpringRedirection ({ commit }, payload) {
        const { code } = payload

        axiosInstances.springAxiosInst.get(`/authentication/github/oauth-code?code=${code}`)
            .then((res) => {
                // alert("res: " + JSON.stringify(res.data))
                localStorage.setItem("userToken", res.data)
                commit(GITHUB_LOGIN_COMPLETE, true)
            })
    }
}