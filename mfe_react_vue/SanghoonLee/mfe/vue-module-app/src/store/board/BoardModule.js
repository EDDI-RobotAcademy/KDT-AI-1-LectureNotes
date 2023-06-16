import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "./mutations"
import actions from "./actions"
import state from "./states"

Vue.use(Vuex)

const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule