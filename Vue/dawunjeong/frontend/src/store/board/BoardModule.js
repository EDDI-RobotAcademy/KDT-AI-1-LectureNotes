import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

/*
BoardModule의 namespaced를 true로 설정함으로써
다른 컴포넌트에서 BoardModule을 사용할 때 import하지 않고
boardModule이라는 이름으로 사용할 수 있습니다.
*/

const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule
