import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import FoodAggregateRootRegisterPage from '@/views/aggregateRootTest/FoodAggregateRootRegisterPage.vue'

Vue.use(VueRouter)

const foodRoutes = [
  {
    path: '/food-register',
    name: 'FoodAggregateRootRegisterPage',
    component: FoodAggregateRootRegisterPage
  },
]

export default foodRoutes
