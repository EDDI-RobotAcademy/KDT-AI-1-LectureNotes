import Vue from "vue";
import VueRouter from "vue-router";
import D3PlotTestPage from "@/views/plot/D3PlotTestPage.vue";
import PlotProblemPage from "@/views/plot/PlotProblemPage.vue";

Vue.use(VueRouter);

const d3PlotTestRoutes = [
  {
    path: "/d3-plot-page",
    name: "D3PlotTestPage",
    component: D3PlotTestPage,
  },
  {
    path: "/plot-problem-page",
    name: "PlotProblemPage",
    component: PlotProblemPage,
  },
];
export default d3PlotTestRoutes;
