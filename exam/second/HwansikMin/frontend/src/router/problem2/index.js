import Vue from 'vue'
import VueRouter from 'vue-router'
import '@/views/problem2/problempage2'

Vue.use(VueRouter)

const boardRoutes = [
    {
        path: '/problem-page2',
        name: 'ProblemPage2',
        component: ProblemPage2
    },
]