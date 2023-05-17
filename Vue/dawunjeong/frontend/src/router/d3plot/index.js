import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3PlotStudyPage from '@/views/plot/D3PlotStudyPage.vue'
import D3HealthHomeworkPage from '@/views/plot/D3HealthHomeworkPage.vue'

Vue.use(VueRouter)

const d3ploatTestRoutes = [
  {
    path: '/d3-plot-test',
    name: 'D3PlotTestPage',
    component: D3PlotTestPage
  },
  {
    path: '/d3-plot-study',
    name: 'D3PlotStudyPage',
    component: D3PlotStudyPage
  },
  {
    path: '/d3-health-homework-page',
    name: 'D3HealthHomeworkPage',
    component: D3HealthHomeworkPage
  },
]

export default d3ploatTestRoutes
