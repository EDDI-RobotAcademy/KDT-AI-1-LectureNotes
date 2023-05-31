import Vue from "vue";
import VueRouter from "vue-router";

import vuetifyTestRoutes from "./uiVuetify";
import productRoutes from "./product";
import boardRoutes from "./board";
import problemRoutes from "./problems";
import lifeCycleRoutes from "./lifeCycle";
import axiosTestRoutes from "./axiosTest";
import componentTestRoutes from "./componentTest";
import vueBasicRoutes from "./vueBasic";
import htmlCssRoutes from "./htmlCss";
import defaultSetRoutes from "./defaultRouterSet";
import d3PlotTestRoutes from "./d3plot";
import foodRoutes from "./food";
import sanrioRoutes from "./sanrio";
import test2Routes from "./test2";

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
  ...productRoutes,
  ...vuetifyTestRoutes,
  ...d3PlotTestRoutes,
  ...foodRoutes,
  ...sanrioRoutes,
  ...test2Routes,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
