import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule'
import uiVuetifyModule from '@/store/uiVeutify/UiVuetifyModule'
import d3PlotModule from '@/store/d3Plot/D3PlotModule'
import fileModule from '@/store/files/FileModule'
import foodModule from '@/store/food/FoodModule'
import FastApiModule from './fastapi/FastApiModule'

Vue.use(Vuex)

// BoardMoudle을 boardMoudle로 사용 가능하게 만들어줌
const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    fileModule: fileModule,
    foodModule: foodModule,
    fastApiModule: FastApiModule
  }
})

export default store