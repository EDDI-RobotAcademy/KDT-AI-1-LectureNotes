import Vue from 'vue'
import VueRouter from 'vue-router'

import ProblemPage from '@/views/homeworks/problem/ProblemPage'
import Problem2Page from '@/views/homeworks/problem2/Problem2Page'
import Problem3Page from '@/views/homeworks/problem3/Problem3Page'
import Problem4Page from '@/views/homeworks/problem4/Problem4Page'
import Problem5Page from '@/views/homeworks/problem5/Problem5Page'

Vue.use(VueRouter)

const problemRoutes  = [
  {
    path: '/problem-page1',
    name: 'ProblemPage',
    component: ProblemPage
  },
  {
    path: '/problem-page2',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/problem-page3',
    name: 'Problem3Page',
    component: Problem3Page
  },
  {
    path: '/problem-page4',
    name: 'Problem4Page',
    component: Problem4Page
  },
  {
    path: '/problem-page5',
    name: 'Problem5Page',
    component: Problem5Page
  },

]

export default problemRoutes