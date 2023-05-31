import Vue from 'vue'
import VueRouter from 'vue-router'

import diceTestRoutes from './dice'
import vueTestRoutes from './vueTestRouter'
import componentTestRoutes from './uiVuetify'
import testRoutes from './test'
import problemRoutes from './problem'
import boardRoutes from './board'
import vuetifyTestRoutes from './uiVuetify'
import defaultSetRoutes from './home'
import d3plot from './d3plot'
import filesTestRoutes from './files'
import FoodSetRoutes from './food'
import ProductRoutes from './product'
import VueSpringTestRoutes from './vueSpringTest'

Vue.use(VueRouter)

const routes = [
  ...d3plot,
  ...defaultSetRoutes,
  ...diceTestRoutes,
  ...vueTestRoutes,
  ...componentTestRoutes,
  ...testRoutes,
  ...problemRoutes,
  ...boardRoutes,
  ...vuetifyTestRoutes,
  ...filesTestRoutes,
  ...FoodSetRoutes,
  ...ProductRoutes,
  ...VueSpringTestRoutes,
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
