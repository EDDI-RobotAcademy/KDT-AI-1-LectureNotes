import Vue from "vue";
import VueRouter from "vue-router";
// @는 현재 src 폴더를 의미함
import D3PlotTestPage from "@/views/plot/D3PlotTestPage.vue"

Vue.use(VueRouter);

const plotRoutes = [
  {
    path: "/d3-plot-page",
    name: "D3PlotTestPage",
    component: D3PlotTestPage,
  },
];

export default plotRoutes;
