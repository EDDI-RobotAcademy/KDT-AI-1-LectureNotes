import Vue from 'vue'
import Vuex from 'vuex'
import memberModule from './problem14/MemberModule'

Vue.use(Vuex)
const store = new Vuex.Store({
  modules:{
    memberModule: memberModule,
  }

})
export default store
