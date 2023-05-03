import Vue from "vue";
import VueRouter from "vue-router";

import boardRoutes from "./board";
import problemRoutes from "./problems";
import lifeCycleRoutes from "./lifeCycle";
import axiosTestRoutes from "./axiosTest";
import componentTestRoutes from "./componentTest";
import vueBasicRoutes from "./vueBasic";
import htmlCssRoutes from "./htmlCss";
import vuetifyTestRoutes from "./uiVuetify";
import defaultSetRoutes from "./defaultRouterSet";
import d3PlotTestRoutes from "./d3plot";

Vue.use(VueRouter);

const routes = [
  ...defaultSetRoutes,

  ...htmlCssRoutes,
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...lifeCycleRoutes,
  ...problemRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes,
  ...d3PlotTestRoutes,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
