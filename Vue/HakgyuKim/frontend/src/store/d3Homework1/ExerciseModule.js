import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/d3Homework1/mutations"
import actions from "@/store/d3Homework1/actions"
import state from "@/store/d3Homework1/state"

Vue.use(Vuex)

// state, actions, mutations 맵핑을 위함
const ExerciseModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default ExerciseModule