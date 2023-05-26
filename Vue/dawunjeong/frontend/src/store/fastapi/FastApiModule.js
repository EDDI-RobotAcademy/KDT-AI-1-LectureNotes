import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/fastapi/mutations"
import actions from "@/store/fastapi/actions"
import state from "@/store/fastapi/states"

Vue.use(Vuex)

const FastApiModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default FastApiModule