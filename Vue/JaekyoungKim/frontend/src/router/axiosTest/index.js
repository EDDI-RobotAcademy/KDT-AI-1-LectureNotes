import Vue from 'vue'
import VueRouter from 'vue-router'
import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'
import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage'

Vue.use(VueRouter)

const axiosTestRoutes = [
 {
    path: '/random-dice-from-spring',
    name: 'DataResponseFromSpringPage',
    component: DataResponseFromSpringPage
  },  {
    path: '/data-send-test-page',
    name: 'DataSendTestPage',
    component: DataSendTestPage
  },


]

export default axiosTestRoutes
