import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3HealthPrintPagelot from '@/views/plot/D3HealthPrintPagelot.vue'


Vue.use(VueRouter)

const d3PlotTestRoutes = [
  {
    path: '/d3-plot-test',
    name: 'D3PlotTestPage',
    component: D3PlotTestPage
  },
  {
    path: '/d3-health-print-test',
    name: 'D3HealthPrintPagelot',
    component: D3HealthPrintPagelot
  },


]

export default d3PlotTestRoutes