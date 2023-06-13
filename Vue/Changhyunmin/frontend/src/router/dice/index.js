import Vue from 'vue'
import VueRouter from 'vue-router'

import DataResponseFromSpringPage from '@/views/axios/DataResponseFromSpringPage.vue'
import DiceGame from '@/views/dice/DiceGame'

Vue.use(VueRouter)

const diceTestRoutes  = [
  {
    path: '/random-dice-from-spring',
    name: 'DataResponseFromSpringPage',
    component: DataResponseFromSpringPage
  },
  {
    path: '/dicegame',
    name: 'DiceGame',
    component: DiceGame
  },

]

export default diceTestRoutes