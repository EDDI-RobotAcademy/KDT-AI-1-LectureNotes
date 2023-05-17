import Vue from "vue";
import VueRouter from "vue-router";

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

Vue.use(VueRouter);

const problemRoutes = [
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
];

export default problemRoutes;
