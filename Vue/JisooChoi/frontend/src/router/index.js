import Vue from "vue";
import VueRouter from "vue-router";

import vuetifyTestRoutes from './uiVuetify'
import boardRoutes from './board'
import problemRoutes from './problems'
import lifeCycleRoutes from './lifeCycle'
import axiosTestRoutes from './axiosTest'
import componentTestRoutes from './componentTest'
import vueBasicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import defaultRouterSet from './defaultRouterSet'

Vue.use(VueRouter);

const routes = [
  ...defaultRouterSet,
  ...htmlCssRoutes,
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...lifeCycleRoutes,
  ...problemRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
