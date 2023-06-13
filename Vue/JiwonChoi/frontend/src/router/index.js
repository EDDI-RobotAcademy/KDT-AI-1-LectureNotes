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
import sanrioRoutes from "./sanrio";
import test2Routes from "./test2";

import foodSetRoutes from "./food";

import accountTestRoutes from "./account";
import authenticationTestRoutes from "./authentication";

import paymentRoutes from "./payment";
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

  ...sanrioRoutes,
  ...test2Routes,
  ...foodSetRoutes,
  ...accountTestRoutes,
  ...authenticationTestRoutes,

  ...paymentRoutes,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
