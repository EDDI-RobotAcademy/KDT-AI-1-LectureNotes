import { createRouter, createWebHistory } from 'vue-router'

import GithubSignInPage from '../page/github/GithubSignInPage.vue'

const routes = [
  {
    path: '/vue-member-app/sign-in',
    name: 'GithubSignInPage',
    component: GithubSignInPage
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
