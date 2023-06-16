import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/fastapiHomework/actions"

Vue.use(Vuex)

const FastApiHomeworkModule = {
    namespaced: true,
    actions,
}

export default FastApiHomeworkModule