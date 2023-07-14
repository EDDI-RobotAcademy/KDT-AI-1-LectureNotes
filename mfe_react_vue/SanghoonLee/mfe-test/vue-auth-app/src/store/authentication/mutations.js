import {
    GITHUB_LOGIN_COMPLETE,
    SAVE_USER_TOKEN,
} from './mutation-types'

export default {
    [GITHUB_LOGIN_COMPLETE] (state, receivedData) {
        state.isAuthenticated = receivedData
    },
    [SAVE_USER_TOKEN] (state, receivedData) {
        state.accessToken = receivedData
    }
}