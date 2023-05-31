import {
    GITHUB_LOGIN_COMPLETE,
} from './mutation-types'

export default {
    [GITHUB_LOGIN_COMPLETE] (state, receivedData) {
        state.isAuthenticated = receivedData}
    }