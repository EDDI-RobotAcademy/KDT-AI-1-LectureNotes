import Vue from "vue";
import VueRouter from "vue-router";

import FastApiDataSendTestPage from "@/views/fastapi/FastApiDataSendTestPage.vue"

Vue.use(VueRouter);

const fastApiRoutes = [
    {
        path: "/fastapi-data-send-page",
        name: "FastApiDataSendTestPage",
        component: FastApiDataSendTestPage,
      },
]

export default fastApiRoutes