import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiDataSendTestRage from '@/views/fastapi/FastApiDataSendTestRage.vue'
import FastApiProblem from '@/views/fastapi/FastApiProblem.vue'

Vue.use(VueRouter)

const fastApiTestRoutes = [
    {
        path: '/fastapi-test-page',
        name: 'FastApiDataSendTestRage',
        component: FastApiDataSendTestRage
    },
    {
        path: '/fastapi-prob',
        name: 'FastApiProblem',
        component: FastApiProblem
    }

]

export default fastApiTestRoutes