import Vue from "vue";
import Vuex from "vuex";

import actions from "@/store/sanrio/actions";
import state from "@/store/sanrio/state";
import mutation from "@/store/sanrio/mutation";

Vue.use(Vuex);

const sanrioModule = {
  namespaced: true,
  state,
  actions,
  mutation,
};

export default sanrioModule;
