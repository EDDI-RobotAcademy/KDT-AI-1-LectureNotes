import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/buisness/mutations"
import actions from "@/store/buisness/actions"
import state from "@/store/buisness/states"

Vue.use(Vuex)

const BuisnessModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BuisnessModule