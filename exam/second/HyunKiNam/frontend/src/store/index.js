import Vue from 'vue'
import Vuex from 'vuex'

import productModule from '@/store/product/ProductModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    productModule: productModule,
  }
})

export default store