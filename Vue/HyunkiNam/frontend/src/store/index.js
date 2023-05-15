import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board'
import uiVuetifyModule from '@/store/uiVeutify'
import d3PlotModule from '@/store/d3Plot'
import fileModule from '@/store/files'
import foodModule from './food/FoodModule'

Vue.use(Vuex)

// BoardMoudle을 boardMoudle로 사용 가능하게 만들어줌
const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    fileModule: fileModule,
    foodModule: foodModule,
  }
})

export default store