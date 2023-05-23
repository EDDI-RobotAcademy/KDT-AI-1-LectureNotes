import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductListPage from '@/views/product/ProductListPage.vue'


Vue.use(VueRouter)

const productTestRoutes = [
  {
  path: '/product-list-page',
  name: 'ProductListPage',
  component:ProductListPage
},


]

export default productTestRoutes
