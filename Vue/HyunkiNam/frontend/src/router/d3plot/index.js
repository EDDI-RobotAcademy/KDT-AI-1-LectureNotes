import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3PlotHomeworkPage from '@/views/homework/D3PlotHomeworkPage.vue'


Vue.use(VueRouter)

const d3plotTestRoutes = [
    {
        path: '/d3plot-test-page',
        name: 'D3PlotTestPage',
        component: D3PlotTestPage
    },
    {
        path: '/d3plot-homework-page',
        name: 'D3PlotHomeworkPage',
        component: D3PlotHomeworkPage
    },

]

export default d3plotTestRoutes

