import { createRouter, createWebHistory } from 'vue-router'

import GithubSignInPage from '../page/github/GithubSignInPage.vue'
import GithubGetAccessToken from '../components/GithubGetAccessToken.vue'
import AfterGithubAuthorizeRequest from "../components/AfterGithubAuthorizeRequest.vue";
import BoardReadPage from "vue-module-app/src/domain/board/page/BoardReadPage.vue";

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
  {
    path: '/after-github-authorize-request',
    name: 'AfterGithubAuthorizeRequest',
    component: AfterGithubAuthorizeRequest,
    components: { default: AfterGithubAuthorizeRequest },
    props: { default: true },
    meta: { hideUrlParams: true },
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
