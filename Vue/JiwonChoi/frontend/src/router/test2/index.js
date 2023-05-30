import Vue from "vue";
import VueRouter from "vue-router";

import test2_1 from "@/views/test2/test2_1.vue";
import test2_3 from "@/views/test2/test2_3.vue";

Vue.use(VueRouter);

const test2Routes = [
  {
    path: "/test2-1",
    name: "test2_1",
    component: test2_1,
  },
  {
    path: "/test2-3",
    name: "test2_3",
    component: test2_3,
  },
];

export default test2Routes;
