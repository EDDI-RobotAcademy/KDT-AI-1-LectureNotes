import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/uivuetify/mutations.js"
import actions from "@/store/uivuetify/actions.js"
import state from "@/store/uivuetify/states.js"

Vue.use(Vuex)

const UivuetifyModule = {
    namespaced: true,
    state, //데이터
    actions, // 비동기를 필요로하는 메소드
    
    mutations, //데이터를 변형시키는 메소드
}

export default UivuetifyModule