import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/vueSpringFastApi/actions"

Vue.use(Vuex)

const vueSpringFastApiModule = {
    namespaced: true,
    actions,
}

export default vueSpringFastApiModule