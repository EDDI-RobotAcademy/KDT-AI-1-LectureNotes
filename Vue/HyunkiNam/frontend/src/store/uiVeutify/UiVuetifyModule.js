import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/uiVeutify/mutations"
import actions from "@/store/uiVeutify/actions"
import state from "@/store/uiVeutify/states"

Vue.use(Vuex)

const UiVuetifyModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default UiVuetifyModule