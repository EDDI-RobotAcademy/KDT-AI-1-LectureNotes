import Vue from 'vue'
import Vuex from 'vuex'

import state from '@/store/board/states'
import actions from '@/store/board/actions'
import mutations from '@/store/board/mutations'
Vue.use(Vuex)

const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule