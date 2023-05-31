import Vue from 'vue'
import VueRouter from 'vue-router'

import Test7 from '@/views/secondExam/Test7/Test7.vue';

Vue.use(VueRouter)

const Test7routes = [
  {
    path: '/test-seven-page',
    name: 'Test7',
    component: Test7
  },
]

export default Test7routes
