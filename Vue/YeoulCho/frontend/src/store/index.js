import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import uiVuetifyModule from '@/store/uivuetify/UiVuetifyModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import filesModule from './file/FilesModule'
import foodModule from './food/FoodModule'
import fastApiModule from './fastapi/FastApiModule'
Vue.use(Vuex)
// Vuex를 사용하여 Store 객체를 생성
const store = new Vuex.Store({
  //store 내 BoardModule을 전역으로 사용하겠다.
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
    fastApiModule: fastApiModule

  },
})

export default store