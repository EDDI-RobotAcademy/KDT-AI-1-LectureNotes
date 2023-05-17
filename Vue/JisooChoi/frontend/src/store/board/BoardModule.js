import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

// 프론트도 도메인을 보고 있어야 한다.
// 우리는 현재 board 도메인을 보고 있다.
// 그렇기 때문에 이 모듈도 도메인 단위로 가지고 있는 것이다.

const BoardModule = {
    // namespace를 지정함으로써
    // 이 모듈에 있는 actions, mutations, state 등이 자동으로 해당 모듈과 매핑되기 때문이다.
    namespaced: true,
    state, // 게시물 상태
    actions,
    mutations,
}

export default BoardModule