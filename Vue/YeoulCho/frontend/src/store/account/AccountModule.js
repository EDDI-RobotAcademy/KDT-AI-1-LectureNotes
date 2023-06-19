import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/account/mutations"
import actions from "@/store/account/actions"
import state from "@/store/account/states"

Vue.use(Vuex)

const AccountModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default AccountModule