import Vue from "vue";
import Vuex, { Store } from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import uiVuetifyModule from "@/store/uiVuetify/UiVuetifyModule.js";
import d3PlotModule from "./d3Plot/D3PlotModule";
import filesModule from "./files/FilesModule";
import foodModule from "./food/FoodModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
  },
});

export default store;
