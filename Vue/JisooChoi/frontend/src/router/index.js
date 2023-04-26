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
import Problem2Page from "@/views/basics/homework/problem2/review/Problem2Page.vue";

// 숙제3 (과일가게)
import Vueprob3 from "@/views/basics/homework/problem3/Vueprob3.vue";
import Problem3Page from "@/views/basics/homework/problem3/review/Problem3Page.vue";

// 문제 은행 4
import VueProb4 from "@/views/basics/homework/problem4/VueProb4.vue";
import Problem4Page from "@/views/basics/homework/problem4/review/Problem4Page.vue";

// 문제 은행 5
import Problem5Page from "@/views/basics/homework/problem5/review/Problem5Page.vue";

// 숙제6 (backlog 작성하면서 문풀)
import VueProb6 from "@/views/basics/homework/problem6/VueProb6.vue";

// 게시판
import BoardListPage from "@/views/basics/board/BoardListPage.vue";
import BoardRegisterPage from "@/views/basics/board/BoardRegisterPage.vue";
import BoardReadPage from "@/views/basics/board/BoardReadPage.vue";
import BoardModifyPage from "@/views/basics/board/BoardModifyPage.vue"

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
  {
    path: "/vue-prob6",
    name: "VueProb6",
    component: VueProb6,
  },
  {
    path: "/board-list-page",
    name: "BoardListPage",
    component: BoardListPage,
  },
  {
    path: "/board-register-page",
    name: "BoardRegisterPage",
    component: BoardRegisterPage,
  },
  {
    // 멀티 컴포넌트 형태
    path: '/board-read-page/:boardId',
    name: 'BoardReadPage',
    components: { // 페이지가 다른 컴포넌트 어쩌구
      default: BoardReadPage
    },
    props: { // 파라미터 전달을 하기 위해서는 이 코드가 필요하며 값은 true여야 한다.
      default: true
    },
  },
  {
    // 멀티 컴포넌트 형태
    path: '/board-modify-page/:boardId',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    },
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
