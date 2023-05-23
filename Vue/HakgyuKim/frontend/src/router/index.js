import Vue from "vue";
import VueRouter from "vue-router";
// @는 현재 src 폴더를 의미함
import HomeView from "@/views/HomeView.vue";
import AboutView from "@/views/AboutView.vue";
import vuetifyTestRoutes from "./uiVuetify";
import boardRoutes from "./board";
import lifeCycleRoutes from "./lifeCycle";
import axiosTestRoutes from "./axiosTest";
import componentTestRoutes from "./componentTest";
import vueBasicRoutes from "./vueBasic";
import htmlCssRoutes from "./htmlCss";
import homeworkRoutes from "./homework";
import plotRoutes from "./plot";
import filesTestRoutes from "./files";
import foodSetRoutes from "./food";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: AboutView,
  },
  ...htmlCssRoutes,
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...lifeCycleRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes,
  ...homeworkRoutes,
  ...plotRoutes,
  ...filesTestRoutes,
  ...foodSetRoutes,
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
