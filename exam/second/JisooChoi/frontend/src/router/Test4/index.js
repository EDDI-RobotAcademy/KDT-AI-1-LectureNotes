import Vue from 'vue'
import VueRouter from 'vue-router'

import Test4 from '@/views/secondExam/Test4/Test4.vue';

Vue.use(VueRouter)

const Test4routes = [
  {
    path: '/test-four-page',
    name: 'Test4',
    component: Test4
  },
]

export default Test4routes
