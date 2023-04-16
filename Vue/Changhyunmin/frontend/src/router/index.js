import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage'
import DupixWithModelPage from '@/views/basics/vModel/DupixWithModelPage'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage'
import VueMuiltiChcekboxPage from '@/views/basics/vModel/VueMuiltiChcekboxPage'
import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import DataSendTestPage from '@/views/axios/DataSendTestPage.vue'

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
    path: '/CssTest',
    name: 'CssTest',
    component: CssTest

  },
  {
    path: '/vue-data-binding-page',
    name: 'VueDataBindingPage',
    component: VueDataBindingPage
  },
  {
    path: '/vue-click-binding-page',
    name: 'VueClickEventPage',
    component: VueClickEventPage
  },
  {
    path: '/vue-input-binding-page',
    name: 'VueInputEventPage',
    component: VueInputEventPage
  },
  {
    path: '/dupix-with-model-page',
    name: 'DupixWithModelPage',
    component: DupixWithModelPage
  },
  {
    path: '/vue-checkbox-page',
    name: 'VueCheckboxPage',
    component: VueCheckboxPage
  },
  {
    path: '/vue-muilti-chcekbox-page',
    name: 'VueMuiltiChcekboxPage',
    component: VueMuiltiChcekboxPage
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
  }
  
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
