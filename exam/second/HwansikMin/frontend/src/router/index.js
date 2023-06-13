import Vue from 'vue'
import VueRouter from 'vue-router'

import problem1Routes from './problem1'
import problem2Routes from './problem2'
import problem3Routes from './problem3'

Vue.use(VueRouter)

const routes = [

  ...problem1Routes,
  ...problem2Routes,
  ...problem3Routes,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
