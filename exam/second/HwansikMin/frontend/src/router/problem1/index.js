import Vue from 'vue'
import VueRouter from 'vue-router'
import problempage1 from '@/views/problem1/problempage1'


Vue.use(VueRouter)

const problemRoutes = [
    {
        path: '/problem-page1',
        name: 'problempage1',
        component: problempage1
    },
]