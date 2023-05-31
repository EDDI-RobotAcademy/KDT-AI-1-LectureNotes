import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage'
import D3HealthPrintPage from '@/views/plot/D3HealthPrintPage'
Vue.use(VueRouter)

const d3plot  = [
  {
    path: '/d3-plot-test-page',
    name: 'D3PlotTestPage',
    component: D3PlotTestPage
  },
  {
    path: '/d3-health-print-page',
    name: 'D3HealthPrintPage',
    component: D3HealthPrintPage
  },

]

export default d3plot