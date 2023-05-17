import Vue from 'vue'
import VueRouter from 'vue-router'

import ProductListPage from '@/views/product/ProductListPage.vue'

Vue.use(VueRouter)

const productRoutes = [
    {
        path: '/product-list-page',
        name: 'ProductListPage',
        component: ProductListPage
    },
]

export default productRoutes

// product와 관련된 정보만 모여있다는 것을 알 수 있음