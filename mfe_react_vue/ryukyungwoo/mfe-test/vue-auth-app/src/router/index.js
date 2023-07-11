import { createRouter, createWebHistory } from 'vue-router'

import GithubSignInPage from '../page/github/GithubSignInPage.vue'
import GithubGetAccessToken from '../components/GithubGetAccessToken.vue'

const routes = [
  {
    path: '/',
    redirect: '/vue-auth-app/sign-in'
  },
  {
    path: '/vue-auth-app/sign-in',
    name: 'GithubSignInPage',
    component: GithubSignInPage
  },
  {
    path: '/vue-auth-app/get-access-token',
    name: 'GithubGetAccessToken',
    component: GithubGetAccessToken,
    beforeEnter: (to, from, next) => {
      // 네비게이션 가드 로직
      console.log('Route-specific navigation guard')
      next()
    },
    props: (route) => ({
      code: route.query.code
    })
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
