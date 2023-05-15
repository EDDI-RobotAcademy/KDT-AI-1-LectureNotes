import Vue from "vue";
import VueRouter from "vue-router";

import FoodRegisterPage from "@/views/aggregateRootTest/FoodAggregateRootRegisterTestPage.vue"

Vue.use(VueRouter);

const foodTestRoutes = [
  {
    path: "/food-register-page",
    name: "FoodRegisterPage",
    component: FoodRegisterPage,
  },
];

export default foodTestRoutes;
