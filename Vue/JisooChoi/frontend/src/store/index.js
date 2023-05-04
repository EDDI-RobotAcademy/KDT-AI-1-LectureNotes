import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import imageModule from '@/store/image/ImageModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import filesModule from './files/FilesModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    imageModule: imageModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
  },
})

export default store