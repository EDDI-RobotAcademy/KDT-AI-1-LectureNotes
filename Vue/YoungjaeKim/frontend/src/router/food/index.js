import Vue from 'vue'
import VueRouter from 'vue-router'

import FoodAggregateRootTestPage from '@/views/aggregateRootTest/FoodAggregateRootTestPage.vue'

Vue.use(VueRouter)

const foodSetRoutes = [
    {
        path: '/food-register',
        name: 'FoodAggregateRootTestPage',
        component: FoodAggregateRootTestPage
    },
]

export default foodSetRoutes