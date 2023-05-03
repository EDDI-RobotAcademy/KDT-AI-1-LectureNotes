import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from "@/views/plot/D3PlotTestPage.vue"

// Vue + Spring + D3 문제 은행 [ 1 ] 혼자 푸는 중
import D3PlotProb from "@/views/basics/homework/plot/D3PlotProb.vue"

// Vue + Spring + D3 문제 은행 [ 1 ] 답변
import D3HealthPrintPage from '@/views/plot/D3HealthPrintPage.vue'

Vue.use(VueRouter)

const d3plotTestRoutes = [
    {
        path: '/d3plot-test-page',
        name: 'D3PlotTestPage',
        component: D3PlotTestPage
    },
    {
        path: '/d3plot-prob',
        name: 'D3PlotProb',
        component: D3PlotProb
    },
    {
        path: '/d3-health-print-page',
        name: 'D3HealthPrintPage',
        component: D3HealthPrintPage
      },
]

export default d3plotTestRoutes