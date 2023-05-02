import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import ImageModule from "@/store/image/ImageModule.js";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    ImageModule: ImageModule,
  },
});

export default store;
