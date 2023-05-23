import Vue from 'vue'
import VueRouter from 'vue-router'
import FoodAggregateRootRegisterPage from '@/views/aggregateRootTest/FoodAggregateRootRegisterPage.vue'


Vue.use(VueRouter)

const foodRoutes = [
    {
        path: '/food-register-page',
        name: 'FoodAggregateRootRegisterPage',
        component: FoodAggregateRootRegisterPage
      }

]



export default foodRoutes
