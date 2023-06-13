import Vue from 'vue'
import VueRouter from 'vue-router'
import '@/views/problem3/problempage3'

Vue.use(VueRouter)

const boardRoutes = [
    {
        path: '/problem-page3',
        name: 'problempage3',
        component: problempage3
    },
]