import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import productModule from "@/store/product/ProductModule.js";
import uiVuetifyModule from "@/store/uiVuetify/UiVuetifyModule.js";
import d3PlotModule from "./d3Plot/D3PlotModule";
import foodModule from "@/store/food/FoodModule";
import sanrioModule from "@/store/sanrio/sanrioModule.js";
import fastApiModule from "./fastapi/FastApiModule";
import springModule from "./spring/SpringModule";
import accountModule from "./account/AccountModule";
import authenticationModule from "./authentication/AuthenticationModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    foodModule: foodModule,
    sanrioModule: sanrioModule,
    fastApiModule: fastApiModule,
    springModule: springModule,
    accountModule: accountModule,
    authenticationModule: authenticationModule,
  },
});

export default store;
