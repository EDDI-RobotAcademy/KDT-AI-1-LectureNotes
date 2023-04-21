import Vue from "vue";
import VueRouter from "vue-router";
// @는 현재 src 폴더를 의미한다.
import HomeView from "@/views/HomeView.vue";
import HtmlTest from "@/views/html/HtmlTest.vue";
import CssTest from "@/views/css/CssTest.vue";
import VueDataBindingPage from "@/views/basics/binding/VueDataBindingPage.vue";
import VueClickEventPage from "@/views/basics/event/VueClickEventPage.vue";
import VueInputEventPage from "@/views/basics/event/VueInputEventPage.vue";
import DuplexWithModelPage from "@/views/basics/vModel/DuplexWithModelPage.vue";
import VueCheckboxPage from "@/views/basics/vModel/VueCheckboxPage.vue";
import VueMultiCheckboxPage from "@/views/basics/vModel/VueMultiCheckboxPage.vue";
import ComponentTestPage from "@/views/basics/componentTest/ComponentTestPage.vue";
import DataSendTestPage from "@/views/basics/axios/DataSendTestPage.vue";

// 숙제1
import HomeworkComponentTest from "@/views/basics/homework/problem1/HomeworkComponentTest.vue";

import DataResponseFromSpringPage from "@/views/basics/axios/DataResponseFromSpringPage.vue";
import VueLifeCycleTestPage from "@/views/lifeCycle/VueLifeCycleTestPage.vue";

// 숙제2 (기본 문제)
import VueBasicTest from "@/views/basics/homework/problem2/VueBasicTest.vue";

// 숙제2 (심화 문제)
import VueProbTest from "@/views/basics/homework/problem2/VueProbTest.vue";
import Problem2Page from "@/views/basics/homework/review/Problem2Page.vue";

// 숙제3 (과일가게)
import Vueprob3 from "@/views/basics/homework/problem3/Vueprob3.vue";
import Problem3Page from "@/views/basics/homework/review/problem3/Problem3Page.vue";

// 문제 은행 4
import VueProb4 from "@/views/basics/homework/problem4/VueProb4.vue";
import Problem4Page from "@/views/basics/homework/review/problem4/Problem4Page.vue";

// 문제 은행 5
import Problem5Page from "@/views/basics/homework/problem5/review/Problem5Page.vue";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/htmlTest",
    name: "HtmlTest",
    component: HtmlTest,
  },
  {
    path: "/cssTest",
    name: "CssTest",
    component: CssTest,
  },
  {
    path: "/vue-data-binding-page",
    name: "VueDataBindingPage",
    component: VueDataBindingPage,
  },
  {
    path: "/vue-click-event-page",
    name: "VueClickEventPage",
    component: VueClickEventPage,
  },
  {
    path: "/vue-input-event-page",
    name: "VueInputEventPage",
    component: VueInputEventPage,
  },
  {
    path: "/duplex-model-test-page",
    name: "DuplexWithModelPage",
    component: DuplexWithModelPage,
  },
  {
    path: "/checkbox-test-page",
    name: "VueCheckboxPage",
    component: VueCheckboxPage,
  },
  {
    path: "/multi-checkbox-test-page",
    name: "VueMultiCheckboxPage",
    component: VueMultiCheckboxPage,
  },
  {
    path: "/global-componenet-test-page",
    name: "ComponentTestPage",
    component: ComponentTestPage,
  },
  {
    path: "/axios-test-page",
    name: "DataSendTestPage",
    component: DataSendTestPage,
  },
  {
    path: "/homework-global-component",
    name: "HomeworkComponentTest",
    component: HomeworkComponentTest,
  },
  {
    path: "/random-dice-from-spring",
    name: "DataResponseFromSpringPage",
    component: DataResponseFromSpringPage,
  },
  {
    path: "/vue-lifecycle-test",
    name: "VueLifeCycleTestPage",
    component: VueLifeCycleTestPage,
  },
  {
    path: "/vue-prob-test",
    name: "VueProbTest",
    component: VueProbTest,
  },
  {
    path: "/vue-basic-test",
    name: "VueBasicTest",
    component: VueBasicTest,
  },
  {
    path: "/problem-page2",
    name: "Problem2Page",
    component: Problem2Page,
  },
  {
    path: "/problem-page3-alone",
    name: "Vueprob3",
    component: Vueprob3,
  },
  {
    path: "/problem-3page",
    name: "Problem3Page",
    component: Problem3Page,
  },
  {
    path: "/vue-problem-4page-alone",
    name: "VueProb4",
    component: VueProb4,
  },
  {
    path: "/vue-problem-4page",
    name: "Problem4Page",
    component: Problem4Page,
  },
  {
    path: "/vue-problem-5page",
    name: "Problem5Page",
    component: Problem5Page,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
