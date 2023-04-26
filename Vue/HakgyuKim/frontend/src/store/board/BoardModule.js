import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/state"

Vue.use(Vuex)

// state, actions, mutations 맵핑을 위함
const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule