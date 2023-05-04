import Vue from "vue";
import VueRouter from "vue-router";
import DataSendTestPage from "@/views/basics/axios/DataSendTestPage.vue";
import DataResponseFromSpringPage from "@/views/basics/axios/DataResponseFromSpringPage.vue";

Vue.use(VueRouter);

const axiosTestRoutes = [
  {
    path: "/axios-test-page",
    name: "DataSendTestPage",
    component: DataSendTestPage,
  },
  {
    path: "/random-dice-from-spring",
    name: "DataResponseFromSpringPage",
    component: DataResponseFromSpringPage,
  },
];
export default axiosTestRoutes;
