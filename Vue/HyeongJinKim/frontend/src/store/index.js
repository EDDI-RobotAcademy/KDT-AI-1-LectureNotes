import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import productModule from "@/store/product/ProductModule.js";
import uiVuetifyModule from "@/store/uiVuetify/UiVuetifyModule.js";
import d3PlotModule from "@/store/d3Plot/D3PlotModule.js";
import filesModule from "@/store/files/FilesModule.js";
import foodModule from "@/store/food/FoodModule.js";
import fastApiModule from "./fastapi/FastApiModule.js";
import springModule from "./spring/FastApiModule.js";
import accountModule from "./account/AccountModule.js";
import authenticationModule from "./authentication/AuthenticationModule.js";
import AfterLoginModule from "./afterLogin/AfterLoginModule.js";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
    fastApiModule: fastApiModule,
    springModule: springModule,
    accountModule: accountModule,
    authenticationModule: authenticationModule,
    afterLoginModule: AfterLoginModule,
  },
});

export default store;
