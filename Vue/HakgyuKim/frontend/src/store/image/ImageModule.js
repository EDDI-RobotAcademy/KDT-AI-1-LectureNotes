import Vue from "vue";
import Vuex from "vuex";

import actions from "@/store/image/actions";
import state from "@/store/image/state";
import mutations from "@/store/image/mutations";

Vue.use(Vuex);

const ImageModule = {
  namespaced: true,
  actions,
  state,
  mutations,
};

export default ImageModule;
