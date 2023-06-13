import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'

import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'

import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

// 네이밍 이슈 존재 (왜 v-model에 대한 것을 두 번 표현 했는가)
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'

import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'

import ProblemPage1 from '@/views/homework/problem1/ProblemPage.vue'

import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage.vue'

import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'

import Problem2Page from '@/views/homework/problem2/Problem2Page.vue'
import Problem3Page from '@/views/homework/problem3/Problem3Page.vue'
import Problem4Page from '@/views/homework/problem4/Problem4Page.vue'
import Problem5Page from '@/views/homework/problem5/Problem5Page.vue'

import BoardListPage from '@/views/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/board/BoardModifyPage.vue'
import uiVuetify from "@/router/uiVuetify";
import vuetifyTestRoutes from "@/router/uiVuetify";
import FileHandlerPage from "@/views/file/FileHandlerPage.vue";
import FileListShowPage from "@/views/file/FileListShowPage.vue";
import VSPTest from "@/views/basics/axios/VSPTest.vue";


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
    name: 'DuplexWithModelPage',
    component: DuplexWithModelPage
  },
  {
    path: '/checkbox-test-page',
    name: 'VueCheckboxPage',
    component: VueCheckboxPage
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
    path: '/vue-lifecycle-test',
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
    path: '/problem-page5',
    name: 'Problem5Page',
    component: Problem5Page
  },
  {
    path: '/board-list-page',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/board-register-page',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/board-read-page/:boardId',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    },
  },
  {
    path: '/board-modify-page/:boardId',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    },
  },
    ...vuetifyTestRoutes,
  {
    path: '/file-handler-page',
    name: 'FileHandlerPage',
    component: FileHandlerPage
  },
  {
    path: '/file-list-show-page',
    name: 'FileListShowPage',
    component: FileListShowPage
  },
  {
    path: '/vsp-test',
    name: 'VspTest',
    component: VSPTest
  }

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
