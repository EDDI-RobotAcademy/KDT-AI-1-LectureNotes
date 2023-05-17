import Vue from "vue";
import VueRouter from "vue-router";

import FoodAggregateRootRegisterPage from "@/views/aggregateRootTest/FoodAggregateRootRegisterTestPage.vue";

Vue.use(VueRouter);

const foodSetRoutes = [
  {
    path: "/food-register",
    name: "FoodAggregateRootRegisterPage",
    component: FoodAggregateRootRegisterPage,
  },
];

export default foodSetRoutes;
