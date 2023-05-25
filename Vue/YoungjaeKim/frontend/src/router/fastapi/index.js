import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiDataSendPage from '@/views/fastapi/FastApiDataSendPage.vue'

Vue.use(VueRouter)

const fastApiTestRoutes = [
    {
        path: '/fastapi-test-page',
        name: 'FastApiDataSendPage',
        component: FastApiDataSendPage
    }
]

export default fastApiTestRoutes