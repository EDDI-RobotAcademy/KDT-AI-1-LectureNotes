import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'


Vue.use(VueRouter)

const d3plotRoutes = [
    {
        path: '/d3plot-test-page',
        name: 'D3PlotTestPage',
        component: D3PlotTestPage
    }
]



export default d3plotRoutes
