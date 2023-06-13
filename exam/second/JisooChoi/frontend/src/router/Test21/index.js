import Vue from 'vue'
import VueRouter from 'vue-router'

import Test21 from '@/views/secondExam/Test21/Test21.vue';

Vue.use(VueRouter)

const Test21routes = [
  {
    path: '/test-twentyOne-page',
    name: 'Test21',
    component: Test21
  },
]

export default Test21routes
