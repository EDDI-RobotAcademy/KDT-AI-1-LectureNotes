import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/authentication/mutations"
import actions from "@/store/authentication/actions"
import state from "@/store/authentication/states"

Vue.use(Vuex)

const AuthenticationModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default AuthenticationModule