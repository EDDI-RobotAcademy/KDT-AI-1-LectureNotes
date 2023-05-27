import Vue from "vue";
import VueRouter from "vue-router";

import Exam1Page from "@/views/exam/Exam1Page.vue";
import Exam2Page from "@/views/exam/Exam2Page.vue";
import Exam3Page from "@/views/exam/Exam3Page.vue";
import Exam4Page from "@/views/exam/Exam4Page.vue";
import Exam7Page from "@/views/exam/Exam7Page.vue";
import Exam8Page from "@/views/exam/Exam8Page.vue";
import Exam9Page from "@/views/exam/Exam9Page.vue";
import Exam14Page from "@/views/exam/Exam14Page.vue";
import Exam15Page from "@/views/exam/Exam15Page.vue";
import Exam16Page from "@/views/exam/Exam16Page.vue";
import Exam20Page from "@/views/exam/Exam20Page.vue";

Vue.use(VueRouter);

const examRoutes = [
  {
    path: "/exam1-page",
    name: "Exam1Page",
    component: Exam1Page,
  },
  {
    path: "/exam2-page",
    name: "Exam2Page",
    component: Exam2Page,
  },
  {
    path: "/exam3-page",
    name: "Exam3Page",
    component: Exam3Page,
  },
  {
    path: "/exam4-page",
    name: "Exam4Page",
    component: Exam4Page,
  },
  {
    path: "/exam7-page",
    name: "Exam7Page",
    component: Exam7Page,
  },
  {
    path: "/exam8-page",
    name: "Exam8Page",
    component: Exam8Page,
  },
  {
    path: "/exam9-page",
    name: "Exam9Page",
    component: Exam9Page,
  },
  {
    path: "/exam14-page",
    name: "Exam14Page",
    component: Exam14Page,
  },
  {
    path: "/exam15-page",
    name: "Exam15Page",
    component: Exam15Page,
  },
  {
    path: "/exam16-page",
    name: "Exam16Page",
    component: Exam16Page,
  },
  {
    path: "/exam20-page",
    name: "Exam20Page",
    component: Exam20Page,
  },
];

export default examRoutes;
