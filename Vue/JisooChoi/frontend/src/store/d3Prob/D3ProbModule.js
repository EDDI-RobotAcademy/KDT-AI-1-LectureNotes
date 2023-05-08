import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/d3Prob/mutations"
import actions from "@/store/d3Prob/actions"
import state from "@/store/d3Prob/states"

Vue.use(Vuex)

const D3ProbModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default D3ProbModule