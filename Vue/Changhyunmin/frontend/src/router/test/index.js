import Vue from 'vue'
import VueRouter from 'vue-router'

import DataSendTestPage from '@/views/axios/DataSendTestPage.vue'
import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'
import Baseball from '@/views/basics/baseball/Baseball.vue'
import Test1Page from '@/views/testpage/Test1Page'
import Apple from '@/views/testpage/Apple'
import TestD3Plot from '@/views/testpage/TestD3Plot'
import ImageTest from '@/views/testpage/ImageTest'
import Animetion from '@/views/testpage/Animetion'
import Test2Page from '@/views/testpage/Test2Page'



Vue.use(VueRouter)

const testRoutes  = [
  {
    path: '/data-send-test-page',
    name: 'DataSendTestPage',
    component: DataSendTestPage
  },
  {
    path: '/life-cycle-test-page',
    name: 'VueLifeCycleTestPage',
    component: VueLifeCycleTestPage
  },
  {
    path: '/baseball',
    name: 'Baseball',
    component: Baseball
  },
  {
    path: '/test-page1',
    name: 'Test1Page',
    component: Test1Page
  },
  {
    path: '/test-page',
    name: 'Apple',
    component: Apple
  },
  {
    path: '/test-d3-plot',
    name: 'TestD3Plot',
    component: TestD3Plot
  },
  {
    path: '/image-test',
    name: 'ImageTest',
    component: ImageTest
  },
  {
    path: '/animetion',
    name: 'Animetion',
    component: Animetion
  },  
  {
    path: '/test-page2',
    name: 'Test2Page',
    component: Test2Page
  },  
]

export default testRoutes