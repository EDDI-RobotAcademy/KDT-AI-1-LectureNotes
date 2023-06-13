import Vue from 'vue'
import VueRouter from 'vue-router'

import Test2 from '@/views/secondExam/Test2/Test2.vue';

Vue.use(VueRouter)

const Test2routes = [
  {
    path: '/test-two-page',
    name: 'Test2',
    component: Test2
  },
]

export default Test2routes
