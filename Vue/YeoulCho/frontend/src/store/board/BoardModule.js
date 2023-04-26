import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

const BoardModule = {
    namespaced: true,
    state, //데이터
    actions, // 비동기를 필요로하는 메소드
    
    mutations, //데이터를 변형시키는 메소드
}

export default BoardModule