import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import productRoutes from './product'
import boardRoutes from './board'
import vuetifyTestRoutes from './uiVuetify'
import prolblemsRoutes from './problems'
import lifeCycleRoutes from './lifeCycle'
import axiosTestRoutes from './axiosTest'
import componentTestRoutes from './componentTest'
import vueBasicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import defaultSetRoutes from './defaultRouterSet'
import solvedRoutes from './solved'
import d3plotTestRoutes from './d3plot'
import filesTestRoutes from './files'
import foodSetRoutes from './food'
import fastApiTestRoutes from './fastapi'

// 지저분한 궁극적인 이유?
// 분류가 안되어서 - 즉 도메인 정리가 안됨
// 이제 라우터도 나눈다

Vue.use(VueRouter)

const routes = [
  ...vuetifyTestRoutes,
  // 이렇게 하면 분할한 라우터가 여기에 자동으로 붙음 - 뷰티파이에 대한 라우터구나 알 수 있음
  ...productRoutes,
  ...boardRoutes,
  ...prolblemsRoutes,
  ...lifeCycleRoutes,
  ...axiosTestRoutes,
  ...componentTestRoutes,
  ...vueBasicRoutes,
  ...htmlCssRoutes,
  ...defaultSetRoutes,
  ...solvedRoutes,
  ...d3plotTestRoutes,
  ...filesTestRoutes,
  ...foodSetRoutes,
  ...fastApiTestRoutes,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

