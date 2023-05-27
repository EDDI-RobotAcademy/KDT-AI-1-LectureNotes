import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/product/actions"

Vue.use(Vuex)

const ProductModule = {
    namespaced: true,
    actions,
}

export default ProductModule