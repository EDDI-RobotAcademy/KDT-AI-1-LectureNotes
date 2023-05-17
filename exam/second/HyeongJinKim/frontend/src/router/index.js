import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import problem1page from "@/views/problems/Problem1.vue";
import problem3page from "@/views/problems/Problem3.vue";
import problem5page from "@/views/problems/Problem5.vue";
import problem7page from "@/views/problems/Problem7.vue";
import problem8page from "@/views/problems/Problem8.vue";
import problem14page from "@/views/problems/Problem14.vue";
import problem20page from "@/views/problems/Problem20.vue";

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
    component: () => import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },

  {
    path: "/problem1-page",
    name: "problem1page",
    component: problem1page,
  },
  {
    path: "/problem3-page",
    name: "problem3page",
    component: problem3page,
  },
  {
    path: "/problem5-page",
    name: "problem5page",
    component: problem5page,
  },
  {
    path: "/problem7-page",
    name: "problem7page",
    component: problem7page,
  },
  {
    path: "/problem8-page",
    name: "problem8page",
    component: problem8page,
  },
  {
    path: "/problem14-page",
    name: "problem14page",
    component: problem14page,
  },
  {
    path: "/problem20-page",
    name: "problem20page",
    component: problem20page,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
