import Vue from 'vue'
import Vuex, { Store } from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
Vue.use(Vuex)

const store = new Vuex.Store({
 
  modules: {
    boardModule: boardModule,
  },
})

export default store
