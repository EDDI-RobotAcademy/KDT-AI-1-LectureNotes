import Vue from 'vue'
import VueRouter from 'vue-router'
import problemRoutes from './problem'
import defaultSetRoutes from './defaultRouterSet'
Vue.use(VueRouter)

const routes = [
  ...problemRoutes,
  ...defaultSetRoutes,
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
