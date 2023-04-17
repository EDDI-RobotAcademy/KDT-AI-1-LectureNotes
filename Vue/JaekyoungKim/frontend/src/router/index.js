import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'
import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'
import HomeworkPage from '@/views/homework/HomeworkPage.vue'
import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage'
import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'


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
    path: '/basics/binding',
    name: 'VueDataBinidngPage',
    component: VueDataBindingPage
  },
  {
    path: '/basics/event',
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
    name: 'DuplexWithModelPage',
    component: DuplexWithModelPage
  },
  {
    path: '/vue-checkbox-page',
    name: 'VueCheckboxPage',
    component: VueCheckboxPage
  },
  {
    path: '/multi-checkbox-page',
    name: 'VueMultiCheckboxPage',
    component: VueMultiCheckboxPage
  },
  {
    path: '/global-component-test-page',
    name: 'ComponentTestPage',
    component: ComponentTestPage
  },
  {
    path: '/data-send-test-page',
    name: 'DataSendTestPage',
    component: DataSendTestPage
  },
  {
    path: '/homework-page',
    name: 'HomeworkPage',
    component: HomeworkPage
  },
  {
    path: '/random-dice-from-spring',
    name: 'DataResponseFromSpringPage',
    component: DataResponseFromSpringPage
  },
  {
    path: '/life-cycle-test',
    name: 'VueLifeCycleTestPage',
    component: VueLifeCycleTestPage
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
