import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import productModule from '@/store/product/ProductModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import FilesModule from './files/FilesModule'
import foodModule from './food/FoodModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    FilesModule: FilesModule,
    foodModule: foodModule

  },
})

export default store
