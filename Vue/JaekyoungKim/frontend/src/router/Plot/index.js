import Vue from 'vue'
import VueRouter from 'vue-router'
import D3PlotTestPage from '@/views/plot/D3PlotTestPage.vue'
import D3PlotProblem from '@/views/plot/D3PlotProblem.vue'
import D3HelthPringtPage from '@/views/plot/D3HelthPringtPage.vue'


Vue.use(VueRouter)

const PlotTestRoutes = [
  {
  path: '/d3-plot-test',
  name: 'D3PlotTestPage',
  component:D3PlotTestPage
},
{
  path: '/d3-plot-problem',
  name: 'D3PlotProblem',
  component:D3PlotProblem
},
{
  path: '/d3-health-data',
  name: 'D3HelthPringtPage',
  component:D3HelthPringtPage
},
]

export default PlotTestRoutes
