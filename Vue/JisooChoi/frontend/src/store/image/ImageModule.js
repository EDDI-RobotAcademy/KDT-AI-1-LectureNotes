import Vue from 'vue'
import Vuex from 'vuex'


import mutations from "@/store/image/mutations"
import actions from "@/store/image/actions"
import state from "@/store/image/states"

Vue.use(Vuex)

const ImageModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default ImageModule