import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import productModule from "@/store/product/ProductModule.js";
import uiVuetifyModule from "@/store/uiVuetify/UiVuetifyModule.js";
import d3PlotModule from "@/store/d3Plot/D3PlotModule.js";
import filesModule from "@/store/files/FilesModule.js";
import foodModule from "@/store/food/FoodModule.js";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
  },
});

export default store;
