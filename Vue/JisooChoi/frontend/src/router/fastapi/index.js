import Vue from "vue";
import VueRouter from "vue-router";

import FastAPiDataSendTestPage from "@/views/fastapi/FastAPiDataSendTestPage.vue";

Vue.use(VueRouter);

const fastApiTestRoutes = [
  {
    path: "/fastapi-test-page",
    name: "FastAPiDataSendTestPage",
    component: FastAPiDataSendTestPage,
  },
];

export default fastApiTestRoutes;
