// 내가 보고 적절하게 분배할 것

import Vue from 'vue'
import VueRouter from 'vue-router'

import ProblemPage1 from '@/views/basics/solved/problem1/ProblemPage1.vue'
import ProblemPage2 from '@/views/homework/problem2/ProblemPage2.vue'
import Problem2Page from '@/views/basics/solved/problem2/Problem2Page.vue'
import Problem3Page from '@/views/basics/solved/problem3/Problem3Page.vue'

Vue.use(VueRouter)

const prolblemsRoutes = [
    {
        path: '/problem-page1',
        name: 'ProblemPage1',
        component: ProblemPage1
    },
    {
        path: '/homework2',
        name: 'ProblemPage2',
        component: ProblemPage2
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
]

export default prolblemsRoutes