import Vue from 'vue'
import VueRouter from 'vue-router'

import Test17 from '@/views/secondExam/Test17/Test17.vue';

Vue.use(VueRouter)

const Test17routes = [
  {
    path: '/test-seventeen-page',
    name: 'Test17',
    component: Test17
  },
]

export default Test17routes
