import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'

Vue.use(Vuex)

// BoardMoudle을 boardMoudle로 사용 가능하게 만들어줌
const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
  }
})

export default store