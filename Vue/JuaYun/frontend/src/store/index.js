import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule
  },
})

export default store