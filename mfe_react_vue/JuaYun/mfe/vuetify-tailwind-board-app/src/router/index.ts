import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

import VuetifyBoardList from "../page/VuetifyBoardList.vue"

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'VuetifyBoardList',
    component: VuetifyBoardList
  }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  })
  
export default router