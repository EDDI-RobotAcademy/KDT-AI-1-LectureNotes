import Vue from 'vue'
import Vuex from 'vuex'

import mutations from '@/store/Product/mutations'
import actions from '@/store/Product/actions'
import state from '@/store/Product/states'

Vue.use(Vuex)

const ProductModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default ProductModule