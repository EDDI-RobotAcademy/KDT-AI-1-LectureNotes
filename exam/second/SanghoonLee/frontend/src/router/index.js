import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import FirstProblem from '@/views/problem/FirstProblem.vue'
import ThirdProblem from '@/views/problem/ThirdProblem.vue'
import FifthProblem from '@/views/problem/FifthProblem.vue'
import SeventhProblem from '@/views/problem/SeventhProblem.vue'
import EighthProblem from '@/views/problem/EighthProblem.vue'
import FourteenthProblem from '@/views/problem/FourteenthProblem.vue'
import TwentiethProblem from '@/views/problem/TwentiethProblem.vue'
import TwentythreethProblem from '@/views/problem/TwentythreethProblem.vue'
import TwentysixthProblem from '@/views/problem/TwentysixthProblem.vue'
import TwentyninethProblem from '@/views/problem/TwentyninethProblem.vue'
import ThirtiethProblem from '@/views/problem/ThirtiethProblem.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/first-problem',
    name: 'FirstProblem',
    component: FirstProblem
  },
  {
    path: '/third-problem',
    name: 'ThirdProblem',
    component: ThirdProblem
  },
  {
    path: '/fifth-problem',
    name: 'FifthProblem',
    component: FifthProblem
  },
  {
    path: '/seventh-problem',
    name: 'SeventhProblem',
    component: SeventhProblem
  },
  {
    path: '/eighth-problem',
    name: 'EighthProblem',
    component: EighthProblem
  },
  {
    path: '/fourteenth-problem',
    name: 'FourteenthProblem',
    component: FourteenthProblem
  },
  {
    path: '/twentieth-problem',
    name: 'TwentiethProblem',
    component: TwentiethProblem
  },
  {
    path: '/twentythreeth-problem',
    name: 'TwentythreethProblem',
    component: TwentythreethProblem
  },
  {
    path: '/twentysixth-problem',
    name: 'TwentysixthProblem',
    component: TwentysixthProblem
  },
  {
    path: '/twentynineth-problem',
    name: 'TwentyninethProblem',
    component: TwentyninethProblem
  },
  {
    path: '/thirtieth-problem',
    name: 'ThirtiethProblem',
    component: ThirtiethProblem
  }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
