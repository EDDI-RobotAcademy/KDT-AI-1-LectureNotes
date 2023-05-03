import Vue from 'vue'
import VueRouter from 'vue-router'

// 뷰티파이
import vuetifyTestRoutes from './uiVuetify'
import productRoutes from './product'
import boardRoutes from './board'
import problemRoutes from './problem'
import homeworkRoutes from './homework'
import lifeCycleRoutes from './lifeCycle'
import componentTestRoutes from './conponenTest'
import htmlCssRoutes from './htmlCss'
import defaultSetRoutes from './defaultRouterSet'
import axiosTestRoutes from './axiosTest'
import vueBasicRoutes from './vueBasic'

Vue.use(VueRouter)

const routes = [
  ...vuetifyTestRoutes,
  ...productRoutes,
  ...boardRoutes,
  ...problemRoutes,
  ...homeworkRoutes,
  ...lifeCycleRoutes,
  ...componentTestRoutes,
  ...htmlCssRoutes,
  ...defaultSetRoutes,
  ...axiosTestRoutes,
  ...vueBasicRoutes
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
