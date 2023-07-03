import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiDataSendTestPage from '@/views/fastapi/FastApiDataSendTestPage.vue'

Vue.use(VueRouter)

const fastApiTestRoutes = [
    {
        path: '/fastapi-test-page',
        name: 'FastApiDataSendTestPage',
        component: FastApiDataSendTestPage
    },
]

export default fastApiTestRoutes