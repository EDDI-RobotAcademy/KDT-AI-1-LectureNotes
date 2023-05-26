import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import Test1Page from "@/views/test1/Test1Page.vue";
import Test2Page from "@/views/test2/Test2Page.vue";
import Test3Page from "@/views/test3/Test3Page.vue";
import Test4Page from "@/views/test4/Test4Page.vue";
import Test7Page from "@/views/test7/Test7Page.vue";
import Test8Page from "@/views/test8/Test8Page.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/test1-page",
    name: "Test1Page",
    component: Test1Page,
  },
  {
    path: "/test2-page",
    name: "Test2Page",
    component: Test2Page,
  },
  {
    path: "/test3-page",
    name: "Test3Page",
    component: Test3Page,
  },
  {
    path: "/test4-page",
    name: "Test4Page",
    component: Test4Page,
  },
  {
    path: "/test7-page",
    name: "Test7Page",
    component: Test7Page,
  },
  {
    path: "/test8-page",
    name: "Test8Page",
    component: Test8Page,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
