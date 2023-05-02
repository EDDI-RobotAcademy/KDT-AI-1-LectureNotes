import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함



import vuetifyTestRoutes from './uiVuetify'
import productRoutes from './product'
import problemRoutes from './problems'
import lifeCycleRoutes from './lifeCycle'
import axiosRoutes from './axiosTest'
import componentTestRoutes from './axiosTest'
import basicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import defaultSetRoutes from './defaultRouterSet'



Vue.use(VueRouter)

const routes = [
  ...htmlCssRoutes,
  ...basicRoutes,
  ...componentTestRoutes,
  ...vuetifyTestRoutes,
  ...productRoutes,
  ...problemRoutes,
  ...lifeCycleRoutes,
  ...axiosRoutes,
  ...defaultSetRoutes,

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
