import Vue from 'vue'
import VueRouter from 'vue-router'
//@는 현재 src 폴더를 의미함



import defaultSetRoutes from './defaultRouterSet'
import vueBasicRoutes from './vueBaxic'
import componentTestRoutes from './componentTest'
import axiosTestRoutes from './axiosTest'
import htmlCssRoutes from './htmlCss'
import vueLifeCycleRoutes from './lifeCycle'
import problemRoutes from './problems'
import boardRoutes from './board'
import vuetifyTestRoutes from './uiVuetify/index,'
import d3plotRoutes from './d3plot'
import filesTestRoutes from './files'
import foodRoutes from './food'
import fastapiTestRoutes from './fastapi'
Vue.use(VueRouter)

const routes = [
  
  
  ...defaultSetRoutes,
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...htmlCssRoutes,
  ...vueLifeCycleRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes, //객체가 되서 들어온다? final, 분할해서 재배치하는 작업
  ...problemRoutes,
  ...d3plotRoutes,
  ...filesTestRoutes,
  ...foodRoutes,
  ...fastapiTestRoutes

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
