import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import AccountModule from "./account/AccountModule";
import ProductModule from "./product/ProductModule";

const store = new Vuex.Store({
  modules: {
    AccountModule: AccountModule,
    ProductModule: ProductModule,
  },
});

export default store;
