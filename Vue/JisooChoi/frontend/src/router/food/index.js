import Vue from "vue";
import VueRouter from "vue-router";

// @는 현재 src 폴더를 의미한다.
import FoodAggregateRootRegisterPage from '@/views/aggregateRootTest/FoodAggregateRootRegisterPage.vue'

Vue.use(VueRouter);

const foodSetRoutes = [
  {
    path: "/food-aggregate-root-register-page",
    name: "foodAggregateRootRegisterPage",
    component: FoodAggregateRootRegisterPage,
  },
];

export default foodSetRoutes;
