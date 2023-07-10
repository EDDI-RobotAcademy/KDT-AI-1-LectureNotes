import Vue from 'vue'
import VueRouter from 'vue-router'

import ProblemPage1 from '@/views/homework/problem1/ProblemPage.vue'
import Problem2Page from '@/views/homework/problem2/Problem2Page.vue'
import Problem3Page from '@/views/homework/problem3/Problem3Page.vue'
import Problem4Page from '@/views/homework/problem4/Problem4Page.vue'
import Problem5Page from '@/views/homework/problem5/Problem5Page.vue'

import CompositionProblemPage from '@/views/homework/composition/problem/CompositionProblemPage.vue'

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
        path: '/problem-page4',
        name: 'Problem4Page',
        component: Problem4Page
    },
    {
        path: '/problem-page5',
        name: 'Problem5Page',
        component: Problem5Page
    },
    {
        path: '/composition-problem-page',
        name: 'CompositionProblemPage',
        component: CompositionProblemPage
    },
]

export default problemRoutes
