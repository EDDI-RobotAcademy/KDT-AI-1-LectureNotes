import Vue from 'vue'
import VueRouter from 'vue-router'

import Test1 from '@/views/secondExam/Test1/Test1.vue';

Vue.use(VueRouter)

const Test1routes = [
  {
    path: '/test-one-page',
    name: 'Test1',
    component: Test1
  },
]

export default Test1routes
