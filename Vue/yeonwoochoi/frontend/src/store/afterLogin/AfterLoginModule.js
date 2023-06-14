import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/afterLogin/mutations"
import actions from "@/store/afterLogin/actions"
import state from "@/store/afterLogin/states"

Vue.use(Vuex)

const AfterLoginModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default AfterLoginModule