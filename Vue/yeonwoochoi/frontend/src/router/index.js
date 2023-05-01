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

import BoardListPage from '@/views/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/board/BoardModifyPage.vue'

import ProductListPage from '@/views/product/ProductListPage.vue'
import ProductRegisterPage from '@/views/product/ProductRegisterPage'
import ProductReadPage from '@/views/product/ProductReadPage.vue'
import ProductModifyPage from '@/views/product/ProductModifyPage.vue'

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
    // 멀티 컴포넌트 (읽기 수정)
    // 기존에 만들었던 컴포넌트는 페이지 보여주는것만
    // 취소하면 Modify, list 등 보여주니까 
    path: '/board-modify-page/:boardId',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage // 멀티페이지 중 대표
    },
    props: { 
      default: true // true가 있어야 파라메터가 들어간다. 필수!
    },
  },
  {
    path: '/product-list-page',
    name: 'ProductListPage',
    component: ProductListPage
  },
  {
    path: '/product-register-page',
    name: 'ProductRegisterPage',
    component: ProductRegisterPage
  },
  {
    path: '/product-read-page/:productId',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    },
  },
  {
    path: '/product-modify-page/:productId',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      default: true
    },
  }
]
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
})


export default router
