import Vue from 'vue'
import VueRouter from 'vue-router'
//@는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

//네이밍 이슈 존재 (왜 v-model 에 대한 것을 두 번 표현 했는가)
import DuplexWithModelpage from '@/views/basics/vmodel/DuplexWithModelPage.vue'
import VueCheckboxpage from '@/views/basics/vmodel/VueCheckboxPage.vue'
import VueMultiCheckboxpage from '@/views/basics/vmodel/VueMultiCheckboxPage.vue'

import ComponentTestpage from '@/views/basics/componentTest/ComponentTestPage.vue'

import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'

import AddComponentPage from '@/views/homework/AddComponentPage.vue'

import Problem1Page from "@/views/homework/problem1/Problem1Page.vue"
import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage.vue'

import VueLifecycleTestPage from '@/views/basics/lifeCycle/VueLifecycleTestPage'

import Problem2Page from "@/views/homework/problem2/Problem2Page.vue"
import Problem22Page from "@/views/homework/problem2/problem2re/Problem2.vue"
import BasicProblemPage from "@/views/homework/basicProblem/BasicProblem.vue"
import Problem3Page from "@/views/homework/problem3/Problem3Page.vue"

import StudyPage from "@/views/homework/study/Study.vue"
import Problem4Page from "@/views/homework/problem4/Problem4Page.vue"
import Problem5Page from "@/views/homework/problem5/Problem5Page.vue"

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
    path: '/duplex-model-test-page',
    name: 'DuplexWithModelpage',
    component: DuplexWithModelpage
  },
  {
    path: '/checkbox-test-page',
    name: 'VueCheckboxpage',
    component: VueCheckboxpage
  },
  {
    path: '/multi-checkbox-test-page',
    name: 'VueMultiCheckboxpage',
    component: VueMultiCheckboxpage
  },
  {
    path: '/global-component-test-page',
    name: 'ComponentTestpage',
    component: ComponentTestpage
  },
  {
    path: '/axios-test-page',
    name: 'DataSendTestPage',
    component: DataSendTestPage
  },
  {
    path: '/component-homework-test-page',
    name: 'AddComponentPage',
    component: AddComponentPage
  },
  {
    path: '/problem1-page',
    name: 'Problem1Page',
    component: Problem1Page
  },
  {
    path: '/random-dice-from-spring',
    name: 'DataResponseFromSpringPage',
    component: DataResponseFromSpringPage
  },
  
  {
    path: '/vue-lifecycle-test',
    name: 'VueLifecycleTestPage',
    component: VueLifecycleTestPage
  },
  {
    path: '/problem2-page',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/problem2-2page',
    name: 'Problem22Page',
    component: Problem22Page
  },
  {
    path: '/basic-problem',
    name: 'BasicProblemPage',
    component: BasicProblemPage
  },
  {
    path: '/problem3-page',
    name: 'Problem3Page',
    component: Problem3Page
  },
  {
    path: '/study-page',
    name: 'StudyPage',
    component: StudyPage
  },
  {
    path: '/problem4-page',
    name: 'Problem4Page',
    component: Problem4Page
  },
  {
    path: '/problem5-page',
    name: 'Problem5Page',
    component: Problem5Page
  }




]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
