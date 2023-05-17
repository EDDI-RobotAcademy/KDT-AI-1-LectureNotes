import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

import CheckboxPage from "@/views/problem1/CheckboxPage";
import SpringGetHi from "@/views/problem2/SpringGetHi";
import OptionPrint from "@/views/problem3/OptionPrint";
import DicePrintPage from "@/views/problem4-6/DicePrintPage";
import ImageGallery from "@/views/problem7/ImageGallery";
import ChangeBanner from "@/views/problem8/ChangeBanner";

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
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/checkbox-page",
    name: "CheckboxPage",
    component: CheckboxPage,
  },
  {
    path: "/spring-get-hi",
    name: "SpringGetHi",
    component: SpringGetHi,
  },
  {
    path: "/option-print",
    name: "OptionPrint",
    component: OptionPrint,
  },
  {
    path: "/dice-print",
    name: "DicePrintPage",
    component: DicePrintPage,
  },
  {
    path: "/image-gallery",
    name: "ImageGallery",
    component: ImageGallery,
  },
  {
    path: "/change-banner",
    name: "ChangeBanner",
    component: ChangeBanner,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
