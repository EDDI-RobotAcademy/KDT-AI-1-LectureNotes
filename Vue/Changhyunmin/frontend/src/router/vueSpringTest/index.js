import Vue from 'vue'
import VueRouter from 'vue-router'

import VueTest1 from '@/views/vueTest/vueTest1/VueTest1'
import VueTest2 from '@/views/vueTest/vueTest2/VueTest2'
import VueTest3 from '@/views/vueTest/vueTest3/VueTest3'
import VueTest4 from '@/views/vueTest/vueTest4/VueTest4'
import VueTest7 from '@/views/vueTest/vueTest7/VueTest7'
import VueTest8 from '@/views/vueTest/vueTest8/VueTest8'
import VueTest9 from '@/views/vueTest/vueTest9/VueTest9'
import VueTest10 from '@/views/vueTest/vueTest10~14//VueTest10'
import VueTest15 from '@/views/vueTest/vueTest15/VueTest15'
import VueTest16 from '@/views/vueTest/vueTest16/VueTest16'
import VueTest17 from '@/views/vueTest/vueTest17~20/VueTest17'
import VueTest21 from '@/views/vueTest/vueTest21~24/VueTest21'
import VueTest25 from '@/views/vueTest/vueTest25~30/VueTest25'
Vue.use(VueRouter)

const VueSpringTestRoutes  = [
  {
    path: '/vue-test-1',
    name: 'VueTest1',
    component: VueTest1
  },
  {
    path: '/vue-test-2',
    name: 'VueTest2',
    component: VueTest2
  },
  {
    path: '/vue-test-3',
    name: 'VueTest3',
    component: VueTest3
  },
  {
    path: '/vue-test-4',
    name: 'VueTest4',
    component: VueTest4
  },
  {
    path: '/vue-test-7',
    name: 'VueTest7',
    component: VueTest7
  },
  {
    path: '/vue-test-8',
    name: 'VueTest8',
    component: VueTest8
  },
  {
    path: '/vue-test-9',
    name: 'VueTest9',
    component: VueTest9
  },
  {
    path: '/vue-test-10',
    name: 'VueTest10',
    component: VueTest10
  },
  {
    path: '/vue-test-15',
    name: 'VueTest15',
    component: VueTest15
  },
  {
    path: '/vue-test-16',
    name: 'VueTest16',
    component: VueTest16
  },
  {
    path: '/vue-test-17',
    name: 'VueTest17',
    component: VueTest17
  },
  {
    path: '/vue-test-21',
    name: 'VueTest21',
    component: VueTest21
  },
  {
    path: '/vue-test-25',
    name: 'VueTest25',
    component: VueTest25
  },
]

export default VueSpringTestRoutes