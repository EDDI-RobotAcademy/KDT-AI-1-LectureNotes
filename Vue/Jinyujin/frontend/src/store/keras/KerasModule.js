import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/keras/actions"

Vue.use(Vuex)

const KerasModule = {
    namespaced: true,
    actions,
}

export default KerasModule