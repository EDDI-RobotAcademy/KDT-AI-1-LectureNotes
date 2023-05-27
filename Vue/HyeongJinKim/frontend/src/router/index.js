import Vue from "vue";
import VueRouter from "vue-router";

import defaultSetRoutes from "./defaultSet";
import htmlCssRoutes from "./htmlCss";
import vueBasicRoutes from "./vueBasic";
import componentTestRoutes from "./componentTest";
import axiosTestRoutes from "./axiosTest";
import lifeCycleRoutes from "./lifeCycle";
import problemRoutes from "./problems";
import boardRoutes from "./board";
import productRoutes from "./product";
import vuetifyTestRoutes from "./uiVuetify";
import d3PlotTestRoutes from "./plot";
import filesTestRoutes from "./files";
import foodSetRoutes from "./food";

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
  ...filesTestRoutes,
  ...foodSetRoutes,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});
export default router;
