import Vue from 'vue'
import Vuex from 'vuex'


import productModule from '@/store/product/ProductModule.js'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
  
    productModule: productModule,

  },
})
//앞으로 BoardModule은 boardModule로 부를 수 있게 됨

export default store