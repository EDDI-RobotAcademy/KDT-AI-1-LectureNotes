import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/spring/mutations"
import actions from "@/store/spring/actions"
import state from "@/store/spring/states"

Vue.use(Vuex)

const SpringModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default SpringModule