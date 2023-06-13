import Vue from 'vue'
import Vuex from 'vuex'

import productModule from '@/store2/product/ProductModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    productModule: productModule,
  },
})

export default store