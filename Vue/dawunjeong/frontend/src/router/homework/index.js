import Vue from 'vue'
import VueRouter from 'vue-router'

// 과제 페이지
import HomeworkPage from '@/views/basics/homework/HomeworkPage.vue'
import DiceDataResponseFromSpringPage from '@/views/basics/axios/homework/DiceDataResponseFromSpringPage.vue'
import DiceGameDataResponseFromSpringPage from '@/views/basics/axios/homework/DiceGameDataResponseFromSpringPage.vue'
import BuyFruitPage from '@/views/homework/problem3/BuyFruitPage.vue'
import GameCharacterPage from '@/views/homework/problem4/GameCharacterPage.vue'
import BuyFruitsPage from '@/views/homework/weekendhomework1/BuyFruitsPage.vue'
import ImagegetPage from '@/views/homework/problem6/ImagegetPage.vue'

Vue.use(VueRouter)

const homeworkRoutes = [
  {
    path: '/homework-test-page',
    name: 'HomeworkPage',
    component: HomeworkPage
  },
  {
    path: '/random-dice-check-win-from-spring',
    name: 'DiceDataResponseFromSpringPage',
    component: DiceDataResponseFromSpringPage
  },
  {
    path: '/random-dice-game-from-spring',
    name: 'DiceGameDataResponseFromSpringPage',
    component: DiceGameDataResponseFromSpringPage
  },
  {
    path: '/buy-fruit-page',
    name: 'BuyFruitPage',
    component: BuyFruitPage
  },
  {
    path: '/game-character-page',
    name: 'GameCharacterPage',
    component: GameCharacterPage
  },
  {
    path: '/buy-fruits-page',
    name: 'BuyFruitsPage',
    component: BuyFruitsPage
  },
  {
    path: '/image-get-page',
    name: 'ImagegetPage',
    component: ImagegetPage
  },
]

export default homeworkRoutes
