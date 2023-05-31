import {
    GITHUB_LOGIN_COMPLETE,
} from './mutation-types'

export default {
    [GITHUB_LOGIN_COMPLETE] (state, receivedData) { //리스트안에 들어있는 형식
        state.isAuthenticated = receivedData
    },
}