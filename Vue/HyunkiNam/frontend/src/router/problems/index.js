import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import Problem4Page from '@/views/homework/Problem4Page.vue'
import Problem5Page from '@/views/homework/Problem5Page.vue'
import HomeworkPage from '@/views/homework/HomeworkPage.vue'

import ProductImagePage from '@/views/homework/ProductImagePage.vue'
import ProductOrderPage from '@/views/homework/ProductOrderPage.vue'

Vue.use(VueRouter)

const problemRoutes = [
    {
        path: '/homework-page',
        name: 'HomeworkPage',
        component: HomeworkPage
    },
    {
        path: '/problem4-page',
        name: 'Problem4Page',
        component: Problem4Page
    },
    {
        path: '/problem5-page',
        name: 'Problem5Page',
        component: Problem5Page
    },
    {
        path: '/product-image-page',
        name: 'ProductImagePage',
        component: ProductImagePage
    },
    {
        path: '/product-order-page',
        name: 'ProductOrderPage',
        component: ProductOrderPage
    },
]

export default problemRoutes