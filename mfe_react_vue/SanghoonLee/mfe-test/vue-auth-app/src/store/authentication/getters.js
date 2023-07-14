export default {
    getAccessToken (state) {
        if (state.accessToken === null) {
            return null;
        }
        return state.accessToken;
    }
}