import Vue from 'vue'
import VueRouter from 'vue-router'

import Test10 from '@/views/secondExam/Test10/Test10.vue';

Vue.use(VueRouter)

const Test10routes = [
  {
    path: '/test-ten-page',
    name: 'Test10',
    component: Test10
  },
]

export default Test10routes
