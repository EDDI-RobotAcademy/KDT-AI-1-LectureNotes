import Vue from 'vue'
import Vuex from 'vuex'

import basicModule from '@/store/basic/BasicModule'
import accountModule from "@/store/account/AccountModule";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    basicModule: basicModule,
    accountModule: accountModule
  }
})
