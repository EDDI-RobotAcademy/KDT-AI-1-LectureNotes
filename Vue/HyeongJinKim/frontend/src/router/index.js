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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});
export default router;
