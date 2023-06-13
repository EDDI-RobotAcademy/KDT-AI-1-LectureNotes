import Vue from 'vue'
import VueRouter from 'vue-router'

import Test25 from '@/views/secondExam/Test25/Test2.vue';

Vue.use(VueRouter)

const Test25routes = [
  {
    path: '/test-twentyFive-page',
    name: 'Test25',
    component: Test25
  },
]

export default Test25routes
