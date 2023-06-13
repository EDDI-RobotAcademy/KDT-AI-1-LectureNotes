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
    /*
        위의 actions을 통해 Github로 이동해서 로그인을 통해 권한 인증(Authorize)이 끝나면
        다시 내 localhost로 돌아오게 되는데 이것이 바로 Redirect 이다.
        일시적으로 사용할 수 있는 코드가 파라미터로 주어지게 되는 것이다.

        Q. 그러면 권한 인증을 하고 난 후에 다시 내 localhost로 돌아오자마자
        아래 actions을 호출하는 부분이 따로 없이 내부적 호출로 이 코드가 실행되는 건가요 ?

        A. GitHub OAuth 으로 생성한 OAuth Apps의 Authorization callback URL을
        http://localhost:8080/github/getAccessToken 으로 설정하였고,
        해당 주소의 컴포넌트는 AccessToken.vue 가 됨으로
        아래 actions 가 호출이 됩니다 !
    */
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