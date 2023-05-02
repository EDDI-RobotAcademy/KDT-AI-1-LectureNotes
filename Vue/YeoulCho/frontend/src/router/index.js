import Vue from 'vue'
import VueRouter from 'vue-router'
//@는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'




import vueBasicRoutes from './vueBaxic'
import componentTestRoutes from './componentTest'
import axiosTestRoutes from './axiosTest'
import htmlCssRoutes from './htmlCss'
import vueLifeCycleRoutes from './lifeCycle'
import problemRoutes from './problems'
import boardRoutes from './board'
import vuetifyTestRoutes from './uiVuetify/index,'
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
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  
  
  ...vueBasicRoutes,
  ...componentTestRoutes,
  ...axiosTestRoutes,
  ...htmlCssRoutes,
  ...vueLifeCycleRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes, //객체가 되서 들어온다? final, 분할해서 재배치하는 작업
  ...problemRoutes,


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
