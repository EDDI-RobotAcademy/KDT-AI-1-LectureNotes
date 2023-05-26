import Vue from 'vue'
import VueRouter from 'vue-router'

import DupixWithModelPage from '@/views/basics/vModel/DupixWithModelPage'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage'
import VueMuiltiChcekboxPage from '@/views/basics/vModel/VueMuiltiChcekboxPage'


Vue.use(VueRouter)

const vueTestRoutes  = [
  {
    path: '/dupix-with-model-page',
    name: 'DupixWithModelPage',
    component: DupixWithModelPage
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
    path: '/vue-checkbox-page',
    name: 'VueCheckboxPage',
    component: VueCheckboxPage
  },
  {
    path: '/vue-muilti-chcekbox-page',
    name: 'VueMuiltiChcekboxPage',
    component: VueMuiltiChcekboxPage
  },
]

export default vueTestRoutes