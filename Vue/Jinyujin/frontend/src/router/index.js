import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'

import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

// 네이밍 이슈 존재 (왜 v-model에 대한 것을 두 번 표현했는가)
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'

// import할 페이지가 뭔지 정확히 확인할 것! 아까 다른 데서 불러 오려고 해서 계속 오류났었음

import ComponentTestHome from '@/views/basics/componentTest/ComponentTestHome.vue'

import VueBasicProblem1 from '@/views/homework/vueBasicProblem1/VueBasicProblem1.vue'
import HiSendTestPage from '@/views/basics/axios/HiSendTestPage.vue'
import HiResponsePage from '@/views/basics/axios/HiResponsePage.vue'

import FruitPriceSum from '@/views/homework/buyFruits/FruitPriceSum.vue'

import DiceGame3 from '@/views/homework/diceGame3/DiceGame3.vue'

import MakeCharacter from '@/views/homework/character/MakeCharacter.vue'

import productRoutes from './product'
import boardRoutes from './board'
import vuetifyTestRoutes from './uiVuetify'
import prolblemsRoutes from './problems'
import lifeCycleRoutes from './lifeCycle'
import axiosTestRoutes from './axiosTest'
import componentTestRoutes from './componentTest'
import vueBasicRoutes from './vueBasic'
import htmlCssRoutes from './htmlCss'
import defaultRouterSet from './defaultRouterSet'
import defaultSetRouter from './defaultRouterSet'
import defaultSetRoutes from './defaultRouterSet'

// 지저분한 궁극적인 이유?
// 분류가 안되어서 - 즉 도메인 정리가 안됨
// 이제 라우터도 sksnsek

Vue.use(VueRouter)

const routes = [
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
    path: '/homework-test-page',
    name: 'ComponentTestHome',
    component: ComponentTestHome
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
    path: '/fruit-price-sum',
    name: 'FruitPriceSum',
    component: FruitPriceSum
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
  ...vuetifyTestRoutes,
  // 이렇게 하면 분할한 라우터가 여기에 자동으로 붙음 - 뷰티파이 라우터구나 알 수 있음
  ...productRoutes,
  ...boardRoutes,
  ...prolblemsRoutes,
  ...lifeCycleRoutes,
  ...axiosTestRoutes,
  ...componentTestRoutes,
  ...vueBasicRoutes,
  ...htmlCssRoutes,
  ...defaultSetRoutes,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

