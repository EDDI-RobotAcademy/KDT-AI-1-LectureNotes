import Vue from 'vue'
import VueRouter from 'vue-router'

import Problem6Page from '@/views/homework/problem6/Problem6Page.vue'

Vue.use(VueRouter)

const homeworkRoutes = [
    {
        path: '/problem-6-page',
        name: 'Problem6Page',
        component: Problem6Page
    },
]

export default homeworkRoutes
