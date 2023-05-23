import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/files/actions"

Vue.use(Vuex)

const FileModule = {
    namespaced: true,
    actions,
}

export default FileModule