import Vue from "vue";
import Vuex from "vuex";

import actions from "@/store/account/actions";

Vue.use(Vuex);

const AccountModule = {
  namespaced: true,
  actions,
};

export default AccountModule;
