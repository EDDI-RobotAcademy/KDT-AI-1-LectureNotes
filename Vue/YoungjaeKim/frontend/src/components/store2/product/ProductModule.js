import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/components/store2/product/mutations"
import actions from "@/components/store2/product/actions"
import state from "@/components/store2/product/states"

Vue.use(Vuex)

const ProductModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default ProductModule