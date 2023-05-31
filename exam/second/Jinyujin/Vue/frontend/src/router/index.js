import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import Problem1Test from '@/views/problem1Test/Problem1Test.vue'
import Problem2Test from '@/views/problem2Test/Problem2Test.vue'
import Problem3Test from '@/views/problem3Test/Problem3Test.vue'
import Problem5Test from '@/views/problem5Test/Problem5Test.vue'
import Problem7Test from '@/views/problem7Test/Problem7Test.vue'
import Problem8Test from '@/views/problem8Test/Problem8Test.vue'
import Problem14Test from '@/views/problem14Test/Problem14Test.vue'
import Problem20Test from '@/views/problem20Test/Problem20Test.vue'
import Problem23Test from '@/views/problem23Test/Problem23Test.vue'
import Problem26Test from '@/views/problem26Test/Problem26Test.vue'

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
    path: '/problem1',
    name: 'Problem1Test',
    component: Problem1Test
  },
  {
    path: '/problem2',
    name: 'Problem2Test',
    component: Problem2Test
  },
  {
    path: '/problem3',
    name: 'Problem3Test',
    component: Problem3Test
  },
  {
    path: '/problem5',
    name: 'Problem5Test',
    component: Problem5Test
  },
  {
    path: '/problem7',
    name: 'Problem7Test',
    component: Problem7Test
  },
  {
    path: '/problem8',
    name: 'Problem8Test',
    component: Problem8Test
  },
  {
    path: '/problem14',
    name: 'Problem14Test',
    component: Problem14Test
  },
  {
    path: '/problem20',
    name: 'Problem20Test',
    component: Problem20Test
  },
  {
    path: '/problem23',
    name: 'Problem23Test',
    component: Problem23Test
  },
  {
    path: '/problem26',
    name: 'Problem26Test',
    component: Problem26Test
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
