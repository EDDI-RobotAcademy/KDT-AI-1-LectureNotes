import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import vuetifyTestRoutes from './uiVuetify'
import boardRoutes from './board'
import problemRoutes from './problems'
import lifeCycleRoutes from './lifeCycle'
import axiosTestRoutes from './axiosTest'
import componentTestRoutes from './componentTest'
import vueBasicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import defaultSetRoutes from './defaultRouterSet'
import d3PlotTestRoutes from './d3plot'
import filesTestRoutes from './files'
import foodSetRoutes from './food'
import fastApiTestRoutes from './fastapi'
import accountTestRoutes from './account'
import authenticationTestRoutes from './authentication'
import afterLoginRoutes from './afterLogin'
import paymentRoutes from './payment'
import chatRoutes from './chat'
import awsS3Routes from './awsS3'



Vue.use(VueRouter)

const routes = [
  ...defaultSetRoutes,
  ...htmlCssRoutes,
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...lifeCycleRoutes,
  ...problemRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes,
  ...d3PlotTestRoutes,
  ...filesTestRoutes,
  ...foodSetRoutes,
  ...fastApiTestRoutes,
  ...accountTestRoutes,
  ...authenticationTestRoutes,
  ...afterLoginRoutes,
  ...paymentRoutes,
  ...chatRoutes,
  ...awsS3Routes
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
export default router