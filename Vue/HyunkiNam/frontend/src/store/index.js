import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import uiVuetifyModule from '@/store/uiVeutify/UiVuetifyModule.js'
import d3PlotModule from '@/store/d3Plot/D3PlotModule.js'
import fileModule from '@/store/files/FileModule.js'

Vue.use(Vuex)

// BoardMoudle을 boardMoudle로 사용 가능하게 만들어줌
const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    fileModule: fileModule,
  }
})

export default store