import Vue from 'vue'
import VueRouter from 'vue-router'

import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3PlotExam from '@/views/plot/D3PlotExam.vue'

Vue.use(VueRouter)

const d3plotTestRoutes = [
    {
        path: '/d3-plot-test',
        name: 'D3PlotTestPage',
        component: D3PlotTestPage
    },
    {
        path: '/d3-plot-exam',
        name: 'D3PlotExam',
        component: D3PlotExam
    },

]

export default d3plotTestRoutes