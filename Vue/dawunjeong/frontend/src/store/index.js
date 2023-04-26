// Vuex를 사용하여 Store 객체를 생성하고 
// 그 Store 객체 내에서 BoardModule를 전역으로 사용하겠다는 내용입니다.
import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
  },
})

export default store
