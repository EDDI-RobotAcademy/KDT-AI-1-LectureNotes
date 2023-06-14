import Vue from 'vue'
import Vuex, { Store } from 'vuex'

import mutations from '@/store/board/mutations'
import actions from '@/store/board/actions'
import states from '@/store/board/states'

Vue.use(Vuex)

const BoardModule = {
 namespaced: true,
 states,
 actions,
 mutations,
  }


export default BoardModule
