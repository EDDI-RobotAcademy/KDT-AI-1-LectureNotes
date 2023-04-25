import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import HomeView from '@/views/HomeView.vue'
import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'

import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'

import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

// 네이밍 이슈 존재 (왜 v-model에 대한 것을 두 번 표현했는가)
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
// import할 페이지가 뭔지 정확히 확인할 것! 아까 다른 데서 불러 오려고 해서 계속 오류났었음
import DataSendTestPage from '@/views/basics/axios/DataSendTestPage.vue'

import ComponentTestHome from '@/views/basics/componentTest/ComponentTestHome.vue'
import ProblemPage1 from '@/views/basics/solved/problem1/ProblemPage1.vue'

import DataResponseFromSpringPage from '@/views/basics/axios/DataResponseFromSpringPage.vue'

import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'

import ProblemPage2 from '@/views/homework/problem2/ProblemPage2.vue'

import VueBasicProblem1 from '@/views/homework/vueBasicProblem1/VueBasicProblem1.vue'
import HiSendTestPage from '@/views/basics/axios/HiSendTestPage.vue'
import HiResponsePage from '@/views/basics/axios/HiResponsePage.vue'

import Problem2Page from '@/views/basics/solved/problem2/Problem2Page.vue'

import FruitPriceSum from '@/views/homework/buyFruits/FruitPriceSum.vue'
import Problem3Page from '@/views/basics/solved/problem3/Problem3Page.vue'

import DiceGame3 from '@/views/homework/diceGame3/DiceGame3.vue'

import MakeCharacter from '@/views/homework/character/MakeCharacter.vue'

import BoardListPage from '@/views/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/board/BoardReadPage.vue'

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
    path: '/homework-test-page',
    name: 'ComponentTestHome',
    component: ComponentTestHome
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
    path: '/homework2',
    name: 'ProblemPage2',
    component: ProblemPage2
  },
  {
    path: '/vue-basic-problem1',
    name: 'VueBasicProblem1',
    component: VueBasicProblem1
  },
  {
    path: '/hi-send-test',
    name: 'HiSendTestPage',
    component: HiSendTestPage
  },
  {
    path: '/hi-response-test',
    name: 'HiResponsePage',
    component: HiResponsePage
  },
  {
    path: '/problem-page2',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/fruit-price-sum',
    name: 'FruitPriceSum',
    component: FruitPriceSum
  },
  {
    path: '/problem-page3',
    name: 'Problem3Page',
    component: Problem3Page
  },
  {
    path: '/dice-game3',
    name: 'DiceGame3',
    component: DiceGame3
  },
  {
    path: '/make-character',
    name: 'MakeCharacter',
    component: MakeCharacter
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
    // :boardId -> 가변정보, 숫자에 따라서 값이 바뀜
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
      // 이렇게 해야 하는 이유? 멀티 컴포넌츠가 되어서 그래
      // 메인이 Read라는걸 알려주는 것
    },
    props: {
      default: true
    }
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

