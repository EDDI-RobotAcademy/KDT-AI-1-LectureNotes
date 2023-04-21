import Vue from 'vue'
import VueRouter from 'vue-router'
// @ 는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueChackboxPage from '@/views/basics/vModel/VueChackboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'

import ProblemPage1 from '@/views/homework/problem1/ProblemPage.vue'

import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage.vue'
import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'

import Problem2Page from '@/views/homework/problem2/Problem2Page.vue'
import Problem3Page from '@/views/homework/problem3/Problem3Page.vue'
import Problem4Page from '@/views/homework/problem4/Problem4Page.vue'
import Prob4Page from '@/views/homework/problem4/prob4/Prob4Page.vue'
import Problem5Page from '@/views/homework/problem5/Problem5Page.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/htmlTest',
    name: 'HtmlTest',
    component: HtmlTest
  },
  
  {
    path: '/cssTest',
    name: 'CssTest',
    component: CssTest
  },
    
  {
    path: '/vue-data-binding-page',
    name: 'VueDataBindingPage',
    component: VueDataBindingPage
  },
  {
    path: '/vue-click-event-page',
    name: 'VueClickEventPage',
    component: VueClickEventPage
  },
  {
    path: '/vue-input-event-page',
    name: 'VueInputEventPage',
    component: VueInputEventPage
  },
  {
    path: '/duplex-with-model-page',
    name: 'DuplexWithModelPage',
    component: DuplexWithModelPage
  },
  {
    path: '/vue-chackbox-page',
    name: 'VueChackboxPage',
    component: VueChackboxPage
  },
  {
    path: '/multi-checkbox-test-page',
    name: 'VueMultiCheckboxPage',
    component: VueMultiCheckboxPage
  },
  {
    path: '/global-component-test-page',
    name: 'ComponentTestPage',
    component: ComponentTestPage
  },
  {
    path: '/axios-test-page',
    name: 'DataSendTestPage',
    component: DataSendTestPage
  },
  {
    path: '/problem-page1',
    name: 'ProblemPage1',
    component: ProblemPage1
  },
  {
    path: '/random-dice-from-spring',
    name: 'DataResponseFromSpringPage',
    component: DataResponseFromSpringPage
  },
  {
    path: '/vue-life-cycle-test-page',
    name: 'VueLifeCycleTestPage',
    component: VueLifeCycleTestPage
  },
  {
    path: '/problem-page2',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/problem-page3',
    name: 'Problem3Page',
    component: Problem3Page
  },
  {
    path: '/problem-page4',
    name: 'Problem4Page',
    component: Problem4Page
  },
  {
    path: '/prob-page4',
    name: 'Prob4Page',
    component: Prob4Page
  },
  {
    path: '/problem-page5',
    name: 'Problem5Page',
    component: Problem5Page
  },
]
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
})

export default router
