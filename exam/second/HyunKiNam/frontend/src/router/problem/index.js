import Vue from 'vue'
import VueRouter from 'vue-router'

import Problem1 from '@/views/exam/Problem1.vue'
import Problem3 from '@/views/exam/Problem3.vue'
import Problem5 from '@/views/exam/Problem5.vue'
import Problem7 from '@/views/exam/Problem7.vue'
import Problem8 from '@/views/exam/Problem8.vue'
import Problem14 from '@/views/exam/Problem14.vue'
import Problem21 from '@/views/exam/Problem21.vue'
import Problem23 from '@/views/exam/Problem23.vue'
import Problem26 from '@/views/exam/Problem26.vue'

Vue.use(VueRouter)

const problemTestRoutes = [
    {
        path: '/problem1-page',
        name: 'Problem1',
        component: Problem1
    },
    {
        path: '/problem3-page',
        name: 'Problem3',
        component: Problem3
    },
    {
        path: '/problem5-page',
        name: 'Problem5',
        component: Problem5
    },
    {
        path: '/problem7-page',
        name: 'Problem7',
        component: Problem7
    },
    {
        path: '/problem8-page',
        name: 'Problem8',
        component: Problem8
    },
    {
        path: '/problem14-page',
        name: 'Problem14',
        component: Problem14
    },
    {
        path: '/problem21-page',
        name: 'Problem21',
        component: Problem21
    },
    {
        path: '/problem23-page',
        name: 'Problem23',
        component: Problem23
    },
    {
        path: '/problem26-page',
        name: 'Problem26',
        component: Problem26
    },
]

export default problemTestRoutes

