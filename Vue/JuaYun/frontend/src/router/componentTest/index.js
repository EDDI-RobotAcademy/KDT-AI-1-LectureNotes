import Vue from 'vue'
import VueRouter from 'vue-router'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'

Vue.use(VueRouter)

const componentTestRoutes = [
    {
        path: '/global-component-test-page',
        name: 'ComponentTestPage',
        component: ComponentTestPage
    },
]

export default componentTestRoutes