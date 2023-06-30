import { createRouter, createWebHistory } from 'vue-router'

import BoardListPage from '../domain/board/page/BoardListPage.vue'
import BoardRegisterPage from '../domain/board/page/BoardRegisterPage.vue'
import BoardReadPage from '../domain/board/page/BoardReadPage.vue'
import BoardModifyPage from '../domain/board/page/BoardModifyPage.vue'

const routes = [
  {
    path: '/',
    redirect: '/vue-module-app'
  },
  {
    path: '/vue-module-app',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
      path: '/vue-module-app/board-register-page',
      name: 'BoardRegisterPage',
      component: BoardRegisterPage,
  },
  {
      path: '/vue-module-app/board-read-page/:boardId',
      name: 'BoardReadPage',
      components: { default: BoardReadPage },
      props: { default: true },
  },
  {
      path: '/vue-module-app/board-modify-page/:boardId',
      name: 'BoardModifyPage',
      components: { default: BoardModifyPage },
      props: { default: true },
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
