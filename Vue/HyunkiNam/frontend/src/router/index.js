import Vue from 'vue'
import VueRouter from 'vue-router'
import vuetifyTestRoutes from './uiVuetify/index.js'
import productRoutes from './product/index.js'
import problemRoutes from './problems/index.js'
import axiosTestRoutes from './axiosTest/index.js'
import practiceRoutes from './practice/index.js'
import vueBasicRoutes from './vueBasic/index.js'
import htmlCssRoutes from './htmlCss/index.js'
import componentTestRoutes from './componentTest/index.js'
import lifeCycleRoutes from './lifeCycle/index.js'
// @는 현재 src 폴더를 의미함

import HomeView from '@/views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',

    component: () => import('../views/AboutView.vue')
  },

  ...lifeCycleRoutes,
  ...htmlCssRoutes,
  ...componentTestRoutes,
  ...practiceRoutes,
  ...vueBasicRoutes,
  ...axiosTestRoutes,
  ...problemRoutes,
  ...productRoutes,
  ...vuetifyTestRoutes,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
