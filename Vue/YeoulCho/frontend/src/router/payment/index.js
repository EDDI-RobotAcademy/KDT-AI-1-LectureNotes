import Vue from 'vue'
import VueRouter from 'vue-router'

import PaymentView from '@/views/payment/Payment.vue'

Vue.use(VueRouter)

const paymentRoutes = [
  {
    path: '/payment-page',
    name: 'PaymentView',
    component: PaymentView
  },
 


]



export default paymentRoutes
