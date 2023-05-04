import Vue from "vue";
import Vuex from "vuex";

import mutations from "@/store/product/mutations";
import actions from "@/store/product/actions";
import state from "@/store/product/states";

Vue.use(Vuex);

const ProductModule = {
  namespaced: true,
  state,
  actions,
  mutations,
};

export default ProductModule;
