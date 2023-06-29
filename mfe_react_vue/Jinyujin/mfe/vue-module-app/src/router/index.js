import { createRouter, createWebHistory} from 'vue-router'

import BoardListPage from '../domain/board/page/BoardListPage.vue'
import BoardRegisterPage from '../domain/board/page/BoardRegisterPage.vue'
import BoardReadPage from '../domain/board/page/BoardReadPage.vue'
import BoardModifyPage from '../domain/board/page/BoardModifyPage.vue'

const routes = [
  {
    path: '/',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/board-register-page',
    name: 'BoardRegisterPage',
    components: { default: BoardRegisterPage },
  },
  {
    path: '/board-read-page/:boardId',
    name: 'BoardReadPage',
    components: { default: BoardReadPage },
    props: { default: true },
  },
  {
    path: '/board-modify-page/:boardId',
    name: 'BoardModifyPage',
    components: { default: BoardModifyPage },
    props: { default: true },
  },
]

const router = createRouter({
  // mode: 'history', // 현 버전에서는 mode가 사라짐
  history: createWebHistory(),
  routes
})

export default router

