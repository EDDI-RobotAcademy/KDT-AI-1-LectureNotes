import Vue from 'vue'
import VueRouter from 'vue-router'

import Test8 from '@/views/secondExam/Test8/Test8.vue';

Vue.use(VueRouter)

const Test8routes = [
  {
    path: '/test-eight-page',
    name: 'Test8',
    component: Test8
  },
]

export default Test8routes
