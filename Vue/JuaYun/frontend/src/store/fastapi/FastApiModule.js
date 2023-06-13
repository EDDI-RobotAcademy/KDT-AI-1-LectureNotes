import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/fastapi/actions"

Vue.use(Vuex)

const FastApiModule = {
    namespaced: true,
    actions,
}

export default FastApiModule