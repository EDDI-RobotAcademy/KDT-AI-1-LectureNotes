import Vue from 'vue'
import VueRouter from 'vue-router'
import defalutRouterSetRoutes from './defaultRouterSet'
import vuetifyTestRoutes from './uiVuetify'
import productRoutes from './product'
import problemRoutes from './problems'
import axiosTestRoutes from './axiosTest'
import practiceRoutes from './practice'
import vueBasicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import componentTestRoutes from './componentTest'
import lifeCycleRoutes from './lifeCycle'
import d3plotTestRoutes from './d3plot'
import fileRoutes from './files'
import foodSetRoutes from './food'
import fastApiTestRoutes from './fastapi'
// @는 현재 src 폴더를 의미함



Vue.use(VueRouter)

const routes = [
  ...defalutRouterSetRoutes,
  ...lifeCycleRoutes,
  ...htmlCssRoutes,
  ...componentTestRoutes,
  ...practiceRoutes,
  ...vueBasicRoutes,
  ...axiosTestRoutes,
  ...problemRoutes,
  ...productRoutes,
  ...vuetifyTestRoutes,
  ...d3plotTestRoutes,
  ...fileRoutes,
  ...foodSetRoutes,
  ...fastApiTestRoutes
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
