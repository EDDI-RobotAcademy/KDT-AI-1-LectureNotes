import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import imageModule from '@/store/image/ImageModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import filesModule from './files/FilesModule'

import d3ProbModule from '@/store/d3Prob/D3ProbModule.js'
import foodModule from '@/store/food/FoodModule.js'
import fastApiModule from '@/store/fastapi/FastApiModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    imageModule: imageModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    d3ProbModule: d3ProbModule,
    foodModule: foodModule,
    fastApiModule : fastApiModule,
  },
})

export default store