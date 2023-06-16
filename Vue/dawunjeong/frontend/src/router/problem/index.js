import Vue from 'vue'
import VueRouter from 'vue-router'

// 과제 선생님 풀이 페이지
import ProblemPage1 from '@/views/homeworkSolve/problem1/ProblemPage.vue'
import Problem2Page from '@/views/homeworkSolve/problem2/Problem2Page.vue'
import Problem3Page from '@/views/homeworkSolve/problem3/Problem3Page.vue'
import CompositionProblemPage from '@/views/homeworkSolve/composition/problem/CompositionProblemPage.vue'

Vue.use(VueRouter)

const problemRoutes = [
  {
    path: '/problem-page1',
    name: 'ProblemPage1',
    component: ProblemPage1
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
    path: '/composition-problem-page',
    name: 'CompositionProblemPage',
    component: CompositionProblemPage
  },
]

export default problemRoutes
