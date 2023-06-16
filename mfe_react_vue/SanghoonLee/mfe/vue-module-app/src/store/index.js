import { createStore } from 'vuex'

import boardModule from './board/BoardModule'

export default createStore({
    modules: {
        boardModule,
    },
});

export { boardModule };