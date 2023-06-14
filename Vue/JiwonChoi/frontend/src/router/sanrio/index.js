import Vue from "vue";
import VueRouter from "vue-router";

import SanrioMainPage from "@/views/sanrio/SanrioMainPage.vue";

Vue.use(VueRouter);

const sanrioRoutes = [
  {
    path: "/sanrio-main-page",
    name: "SanrioMainPage",
    component: SanrioMainPage,
  },
];

export default sanrioRoutes;
