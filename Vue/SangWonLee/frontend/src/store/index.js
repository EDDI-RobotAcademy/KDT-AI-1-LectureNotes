import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import productModule from "@/store/product/productModule.js";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,

    productModule: productModule,

  },
});

export default store;
