import Vue from 'vue'
import VueRouter from 'vue-router'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import ComponentTestHome from '@/views/basics/componentTest/ComponentTestHome.vue'

Vue.use(VueRouter)

const componentTestRoutes = [
    {
        path: '/global-component-test-page',
        name: 'ComponentTestPage',
        component: ComponentTestPage
    },
    {
        path: '/homework-test-page',
        name: 'ComponentTestHome',
        component: ComponentTestHome
    },
]

export default componentTestRoutes