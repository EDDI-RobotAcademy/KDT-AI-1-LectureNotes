import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({ // 왼쪽 store를 전역 객체화
  modules: {
    boardModule: boardModule,
  },
})

export default store