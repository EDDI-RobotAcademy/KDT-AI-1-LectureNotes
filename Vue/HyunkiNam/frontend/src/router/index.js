import Vue from 'vue'
import VueRouter from 'vue-router'
import defalutRouterSetRoutes from './defaultRouterSet/index.js'
import vuetifyTestRoutes from './uiVuetify/index.js'
import productRoutes from './product/index.js'
import problemRoutes from './problems/index.js'
import axiosTestRoutes from './axiosTest/index.js'
import practiceRoutes from './practice/index.js'
import vueBasicRoutes from './vueBasic/index.js'
import htmlCssRoutes from './htmlCss/index.js'
import componentTestRoutes from './componentTest/index.js'
import lifeCycleRoutes from './lifeCycle/index.js'
import d3plotTestRoutes from './d3plot/index.js'
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
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
