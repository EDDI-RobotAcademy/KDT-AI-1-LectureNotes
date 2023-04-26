import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

// 도메인 단위로 관리하기 위에 Module을 가지고 있다.
const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule