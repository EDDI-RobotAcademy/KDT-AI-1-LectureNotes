import Vue from 'vue'
import Vuex from 'vuex'
import state from '@/store/problem14/ststes.js'
import mutations from '@/store/problem14/mutations.js'
import actions from '@/store/problem14/actions.js'
Vue.use(Vuex)

const MemberModule={
  namespaced: true,
  state,
  mutations,
  actions
}

export default MemberModule