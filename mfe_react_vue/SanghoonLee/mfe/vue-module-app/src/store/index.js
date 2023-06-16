import { createStore } from 'vuex'

import boardModule from './modules/BoardModule'

export default createStore({
    modules: {
        boardModule,
    },
});

export { boardModule };