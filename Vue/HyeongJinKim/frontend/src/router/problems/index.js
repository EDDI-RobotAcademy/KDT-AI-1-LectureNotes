import Vue from "vue";
import VueRouter from "vue-router";
// @는 현재 src 폴더를 의미함
import VueBasicProbs from "@/views/homework/basicProblem/VueBasicProbs.vue";
import VueHomeworkPage from "@/views/homework/problem1/VueHomeworkPage.vue";
import VueHomeworkPage2 from "@/views/homework/problem2/Problem2Page.vue";
import VueHomeworkPage3 from "@/components/homework/problem3/VueHomeworkPage3GetMapping.vue";
import VueHomeworkPage3Copy from "@/components/homework/problem3/VueHomeworkPage3PostMapping.vue";
import VueHomeworkPage4 from "@/components/homework/problem4/VueHomeworkPage4.vue";
import VueHomeworkPage5 from "@/views/homework/problem5/VueHomeworkPage5.vue";

Vue.use(VueRouter);

const problemRoutes = [
  {
    path: "/vue-homework-page",
    name: "VueHomeworkPage",
    component: VueHomeworkPage,
  },
  {
    path: "/vue-homework-page2",
    name: "VueHomeworkPage2",
    component: VueHomeworkPage2,
  },
  {
    path: "/vue-homework-page3",
    name: "VueHomeworkPage3",
    component: VueHomeworkPage3,
  },
  {
    path: "/vue-homework-page3-Copy",
    name: "VueHomeworkPage3Copy",
    component: VueHomeworkPage3Copy,
  },
  {
    path: "/vue-homework-page4",
    name: "VueHomeworkPage4",
    component: VueHomeworkPage4,
  },
  {
    path: "/vue-homework-page5",
    name: "VueHomeworkPage5",
    component: VueHomeworkPage5,
  },
  {
    path: "/vue-basic-probs",
    name: "VueBasicProbs",
    component: VueBasicProbs,
  },
];
export default problemRoutes;
