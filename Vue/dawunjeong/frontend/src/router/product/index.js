import Vue from 'vue'
import VueRouter from 'vue-router'

// 상품 페이지(혼자 연습)
import ProductListPage from '@/views/product/ProductListPage.vue'
import ProductRegisterPage from '@/views/product/ProductRegisterPage.vue'
import ProductReadPage from '@/views/product/ProductReadPage.vue'

Vue.use(VueRouter)

const productRoutes = [
      {
        path: '/product-list-page',
        name: 'ProductListPage',
        component: ProductListPage
      },
      {
        path: '/product-register-page',
        name: 'ProductRegisterPage',
        component: ProductRegisterPage
      },
      {
        path: '/product-read-page/:productId',
        name: 'ProductReadPage',
        components: {
          default: ProductReadPage
        },
        props: {
          default: true
        },
      },
  ]


export default productRoutes
