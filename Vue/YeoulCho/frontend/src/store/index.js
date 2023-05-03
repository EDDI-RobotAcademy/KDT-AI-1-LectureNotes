import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'

Vue.use(Vuex)
// Vuex를 사용하여 Store 객체를 생성
const store = new Vuex.Store({
  //store 내 BoardModule을 전역으로 사용하겠다.
  modules: {
    boardModule: boardModule,
  },
})

export default store