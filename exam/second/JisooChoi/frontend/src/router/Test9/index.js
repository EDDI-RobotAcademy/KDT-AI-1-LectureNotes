import Vue from 'vue'
import VueRouter from 'vue-router'

import Test9 from '@/views/secondExam/Test9/Test9.vue';

Vue.use(VueRouter)

const Test9routes = [
  {
    path: '/test-nine-page',
    name: 'Test9',
    component: Test9
  },
]

export default Test9routes
