import Vue from 'vue'
import Vuex from 'vuex'
import boardModule from '@/store/board/BoardModule.js'
import productModule from '@/store/Product/ProductModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import filesModule from './files/FilesModule'
import foodModule from './food/FoodModule'
import fastApiModule from './fastapi/FastApiModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
    fastApiModule: fastApiModule
  },
})

export default store