import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'

import D3HealthPrintPage from '@/views/plot/D3HealthPrintPage.vue'


Vue.use(VueRouter)

const d3PlotTestRoutes = [
  {
    path: '/d3-plot-test',
    name: 'D3PlotTestPage',
    component: D3PlotTestPage
  },
  {
    path: '/d3-health-print-page',
    name: 'D3HealthPrintPage',
    component: D3HealthPrintPage
  },

]

export default d3PlotTestRoutes