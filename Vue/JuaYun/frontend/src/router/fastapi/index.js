import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiDataSendTestRage from '@/views/fastapi/FastApiDataSendTestRage.vue'

Vue.use(VueRouter)

const fastApiTestRoutes = [
    {
        path: '/fastapi-test-page',
        name: 'FastApiDataSendTestRage',
        component: FastApiDataSendTestRage
    }

]

export default fastApiTestRoutes