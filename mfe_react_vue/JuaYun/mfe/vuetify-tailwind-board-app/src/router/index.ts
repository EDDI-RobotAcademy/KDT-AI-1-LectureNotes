import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

import VuetifyBoardList from "../page/VuetifyBoardList.vue"
import VuetifyBoardRegister from "../page/VuetifyBoardRegister.vue"
import VuetifyBoardRead from "../page/VuetifyBoardRead.vue"
import VuetifyBoardModify from "../page/VuetifyBoardModify.vue"

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/vuetify-typescript-board-app'
  },
  {
    path: '/vuetify-typescript-board-app',
    name: 'VuetifyBoardList',
    component: VuetifyBoardList
  },
  {
    path: '/vuetify-typescript-board-app/register',
    name: 'VuetifyBoardRegister',
    component: VuetifyBoardRegister,
  },
  {
    path: '/vuetify-typescript-board-app/read/:boardId',
    name: 'VuetifyBoardRead',
    components: { default: VuetifyBoardRead },
    props: { default: true },
    // components에서 s를 빼면 화면 이 켜지지 않음
  },
  {
    path: '/vuetify-typescript-board-app/modify/:boardId',
    name: 'VuetifyBoardModify',
    components: { default: VuetifyBoardModify },
    props: { default: true },
  },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  })

export default router