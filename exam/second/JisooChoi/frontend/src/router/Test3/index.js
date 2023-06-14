import Vue from 'vue'
import VueRouter from 'vue-router'

import Test3 from '@/views/secondExam/Test3/Test3.vue';

Vue.use(VueRouter)

const Test3routes = [
  {
    path: '/test-three-page',
    name: 'Test3',
    component: Test3
  },
]

export default Test3routes
