import Vue from "vue";
import Vuex from "vuex";

import actions from "@/store/food/actions";

Vue.use(Vuex);

const foodModule = {
  namespaced: true,
  actions,
};

export default foodModule;
