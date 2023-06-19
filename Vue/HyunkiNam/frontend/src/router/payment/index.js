import Vue from 'vue'
import VueRouter from 'vue-router'

import PaymentViewPage from '@/views/payment/PaymentViewPage.vue'
Vue.use(VueRouter)

const paymentRoutes = [
    {
        path: '/payment-page',
        name: 'PaymentViewPage',
        component: PaymentViewPage
    },
]

export default paymentRoutes