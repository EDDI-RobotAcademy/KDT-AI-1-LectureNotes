import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import UiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import D3PlotModule from './d3Plot/D3PlotModule'
import FilesModule from '@/store/files/FilesModule.js'
import FoodModule from '@/store/food/FoodModule.js'
import ProductModule from './product/ProductModule'

Vue.use(Vuex)
const store = new Vuex.Store({
  modules: {
  boardModule: boardModule,
  uiVuetifyModule: UiVuetifyModule,
  d3PlotModule: D3PlotModule,
  filesModule: FilesModule,
  foodMoudle: FoodModule,
  productModule: ProductModule
},
})

export default store