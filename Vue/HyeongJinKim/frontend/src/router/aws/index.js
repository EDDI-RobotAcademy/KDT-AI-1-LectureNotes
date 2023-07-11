import Vue from "vue";
import VueRouter from "vue-router";

import AwsSdkView from "@/views/aws/AwsSdk.vue";

Vue.use(VueRouter);

const awsSdkTestRoutes = [
  {
    path: "/aws-sdk",
    name: "AwsSdkView",
    component: AwsSdkView,
  },
];

export default awsSdkTestRoutes;
