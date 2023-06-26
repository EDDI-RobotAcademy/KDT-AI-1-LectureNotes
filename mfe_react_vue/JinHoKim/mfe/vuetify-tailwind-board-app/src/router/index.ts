import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

import vuetifyBoardList from '../page/VuetifyBoardList.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'VuetifyBoardList',
    component: vuetifyBoardList,
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router