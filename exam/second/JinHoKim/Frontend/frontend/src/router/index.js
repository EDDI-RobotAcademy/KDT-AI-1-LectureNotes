import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Problem1Page from '@/views/problem1/Problem1Page.vue'
import Problem3Page from '@/views/problem3/Problem3Page.vue'
import Problem4Page from '@/views/problem4/Problem4Page.vue'
import Problem7Page from '@/views/problem7/Problem7Page.vue'
import Problem8Page from '@/views/problem8/Problem8Page.vue'
import Problem14Page from '@/views/problem14/Problem14Page.vue'
import Problem18Page from '@/views/problem18/Problem18Page.vue'


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
  {
    path: '/problem1-page',
    name: 'Problem1Page',
    component: Problem1Page
  },
  {
    path: '/problem3-page',
    name: 'Problem3Page',
    component: Problem3Page
  },
  {
    path: '/problem4-page',
    name: 'Problem4Page',
    component: Problem4Page
  },
  {
    path: '/problem7-page',
    name: 'Problem7Page',
    component: Problem7Page
  },
  {
    path: '/problem8-page',
    name: 'Problem8Page',
    component: Problem8Page
  },
  {
    path: '/problem14-page',
    name: 'Problem14Page',
    component: Problem14Page
  },
  {
    path: '/problem18-page',
    name: 'Problem18Page',
    component: Problem18Page
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
