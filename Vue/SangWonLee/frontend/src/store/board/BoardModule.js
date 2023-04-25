import Vue from "vue";
import Vuex from "vuex";

import mutations from "@/store/board/mutations";
import actions from "@/store/board/actions";
import state from "@/store/board/states";

Vue.use(Vuex);

const BoardModule = {
  namespaced: true,
  state,
  actions,
  mutations,
};

export default BoardModule;
