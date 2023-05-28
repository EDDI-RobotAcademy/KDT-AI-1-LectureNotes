import Vue from 'vue'
import VueRouter from 'vue-router'

import FoodAggregateRootRegisterPage from '@/views/aggregateRootTest/FoodAggregateRootRegisterPage.vue'
Vue.use(VueRouter)

const FoodSetRoutes  = [
  {
    path: '/food-register',
    name: 'FoodAggregateRootRegisterPage',
    component: FoodAggregateRootRegisterPage
  },

]

export default FoodSetRoutes