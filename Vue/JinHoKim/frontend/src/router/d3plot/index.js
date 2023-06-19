import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3HealthPrintPage from '@/views/plot/D3HealthPrintPage.vue'
import D3Review1Page from '@/views/plot/D3Review1Page.vue'

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
  {
    path: '/d3-review1-page',
    name: 'D3Review1Page',
    component: D3Review1Page
  }
  
]

export default d3PlotTestRoutes
