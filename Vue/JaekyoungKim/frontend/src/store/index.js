import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import productModule from '@/store/product/ProductModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import d3PlotModule from './d3Plot/D3PlotModule.js'
import filesModule from './file/FilesModule.js'
import foodModule from './food/FoodModule.js'
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule:uiVuetifyModule,
    d3PlotModule:d3PlotModule,
    filesModule:filesModule,
    foodModule:foodModule

  },
})
//앞으로 BoardModule은 boardModule로 부를 수 있게 됨

export default store