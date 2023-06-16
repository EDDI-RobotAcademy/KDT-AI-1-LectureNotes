import Vue from 'vue'
import VueRouter from 'vue-router'

import AfterLoginSamplePage from '@/views/afterLogin/AfterLoginSamplePage.vue'

Vue.use(VueRouter)

const afterLoginTestRoutes = [
    {
        path: '/after-login/sample',
        name: 'AfterLoginSamplePage',
        component: AfterLoginSamplePage
    },
]

export default afterLoginTestRoutes