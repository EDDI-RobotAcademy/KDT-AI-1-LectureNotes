import { createStore } from 'vuex'

import authenticationModule from './authentication/AuthenticationModule'

export default createStore({
    modules: {
        authenticationModule,
    },
});

export { authenticationModule };