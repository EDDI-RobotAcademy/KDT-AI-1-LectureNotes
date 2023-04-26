import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

const BoardModule = {
    namespaced: true, // namespace화 하면 state, actions, mutations가 자졷ㅇ으로 모듈과 맵핑 됨
    state,
    actions,
    mutations,
}

export default BoardModule