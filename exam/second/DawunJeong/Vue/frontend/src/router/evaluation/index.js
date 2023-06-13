import Vue from 'vue'
import VueRouter from 'vue-router'

import Problem1Page from '@/views/evaluation/Problem1Page.vue'
import Problem2Page from '@/views/evaluation/Problem2Page.vue'
import Problem3Page from '@/views/evaluation/Problem3Page.vue'
import Problem4Page from '@/views/evaluation/Problem4Page.vue'
import Problem5Page from '@/views/evaluation/Problem5Page.vue'
import Problem7Page from '@/views/evaluation/Problem7Page.vue'
import Problem8Page from '@/views/evaluation/Problem8Page.vue'
import Problem9Page from '@/views/evaluation/Problem9Page.vue'
import Problem10Page from '@/views/evaluation/Problem10Page.vue'
import Problem14Page from '@/views/evaluation/Problem14Page.vue'
import Problem15Page from '@/views/evaluation/Problem15Page.vue'
import Problem16Page from '@/views/evaluation/Problem16Page.vue'
import Problem17Page from '@/views/evaluation/Problem17Page.vue'
import Problem20Page from '@/views/evaluation/Problem20Page.vue'
import Problem23Page from '@/views/evaluation/Problem23Page.vue'
import Problem25Page from '@/views/evaluation/Problem25Page.vue'
import Problem26Page from '@/views/evaluation/Problem26Page.vue'

import NormalAccountRegisterPage from '@/views/evaluation/account/NormalAccountRegisterPage.vue'
import BusinessAccountRegisterPage from '@/views/evaluation/account/BusinessAccountRegisterPage.vue'
import ProductListPage from '@/views/evaluation/product/ProductListPage.vue'
import ProductReadPage from '@/views/evaluation/product/ProductReadPage.vue'

Vue.use(VueRouter)

const evaluationRoutes = [
  {
    path: '/problem1-page',
    name: 'Problem1Page',
    component: Problem1Page
  },
  {
    path: '/problem2-page',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/problem3-page',
    name: 'Problem3Page',
    component: Problem3Page
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
    path: '/problem7-page',
    name: 'Problem7Page',
    component: Problem7Page
  },
  {
    path: '/problem8-page',
    name: 'Problem8Page',
    component: Problem8Page
  },
  {
    path: '/problem9-page',
    name: 'Problem9Page',
    component: Problem9Page
  },
  {
    path: '/problem10-page',
    name: 'Problem10Page',
    component: Problem10Page
  },
  {
    path: '/problem14-page',
    name: 'Problem14Page',
    component: Problem14Page
  },
  {
    path: '/problem15-page',
    name: 'Problem15Page',
    component: Problem15Page
  },
  {
    path: '/problem16-page',
    name: 'Problem16Page',
    component: Problem16Page
  },
  {
    path: '/problem17-page',
    name: 'Problem17Page',
    component: Problem17Page
  },
  {
    path: '/problem20-page',
    name: 'Problem20Page',
    component: Problem20Page
  },
  {
    path: '/normal-account-register-page',
    name: 'NormalAccountRegisterPage',
    component: NormalAccountRegisterPage
  },
  {
    path: '/business-account-register-page',
    name: 'BusinessAccountRegisterPage',
    component: BusinessAccountRegisterPage
  },
  {
    path: '/problem23-page',
    name: 'Problem23Page',
    component: Problem23Page
  },
  {
    path: '/problem25-page',
    name: 'Problem25Page',
    component: Problem25Page
  },
  {
    path: '/problem26-page',
    name: 'Problem26Page',
    component: Problem26Page
  },
  {
    path: '/product-list-page',
    name: 'ProductListPage',
    component: ProductListPage
  },
  {
    path: '/product-read-page/:id',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    },
  },
]

export default evaluationRoutes