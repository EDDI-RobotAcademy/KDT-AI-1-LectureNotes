import Vue from "vue";
import VueRouter from "vue-router";
// @는 현재 src 폴더를 의미함
import Homework1 from "@/views/homework/Homework1.vue";
import Homework2 from "@/views/homework/Homework2.vue";
import HomeworkBasic1 from "@/views/homework/HomeworkBasic1.vue";
import Homework2Answer from "@/views/homework/answer/Homework2Answer.vue";
import Homework3 from "@/views/homework/Homework3.vue";
import Homework4 from "@/views/homework/problem4/Homework4.vue";

Vue.use(VueRouter);

const homeworkRoutes = [
  {
    path: "/homework1",
    name: "Homework1",
    component: Homework1,
  },
  {
    path: "/homework2",
    name: "Homework2",
    component: Homework2,
  },
  {
    path: "/homework-basic1",
    name: "HomeworkBasic1",
    component: HomeworkBasic1,
  },
  {
    path: "/homework2-answer",
    name: "Homework2Answer",
    component: Homework2Answer,
  },
  {
    path: "/homework3",
    name: "Homework3",
    component: Homework3,
  },
  {
    path: "/homework4",
    name: "Homework4",
    component: Homework4,
  },
];

export default homeworkRoutes;