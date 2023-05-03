import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/d3plot/mutations"
import actions from "@/store/d3plot/actions"
import state from "@/store/d3plot/states"

Vue.use(Vuex)

const D3PlotModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default D3PlotModule