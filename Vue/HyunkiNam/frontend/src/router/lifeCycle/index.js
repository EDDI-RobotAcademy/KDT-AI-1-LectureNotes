import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'

Vue.use(VueRouter)

const lifeCycleRoutes = [
    {
        path: '/vue-lifecycle-test',
        name: 'VueLifeCycleTestPage',
        component: VueLifeCycleTestPage
    },
]

export default lifeCycleRoutes