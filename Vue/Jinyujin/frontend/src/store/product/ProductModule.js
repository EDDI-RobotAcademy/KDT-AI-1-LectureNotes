import Vue from "vue";
import Vuex from "vuex";

import mutations from "../product/mutations";
import actions from "../product/actions";
import state from "../product/states";

Vue.use(Vuex)

const ProductModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default ProductModule