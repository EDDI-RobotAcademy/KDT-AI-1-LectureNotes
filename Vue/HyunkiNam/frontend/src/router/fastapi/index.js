import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiDataSendTestPage from '@/views/fastapi/FastApiDataSendTestPage.vue'
import VueSpringFastAPIPage from '@/views/fastapi/VueSpringFastAPIPage.vue'

Vue.use(VueRouter)

const fastApiTestRoutes = [
    {
        path: '/fastapi-test-page',
        name: 'FastApiDataSendTestPage',
        component: FastApiDataSendTestPage
    },
    {
        path: '/vue-spring-fastapi-page',
        name: 'VueSpringFastAPIPage',
        component: VueSpringFastAPIPage
    }
]

export default fastApiTestRoutes