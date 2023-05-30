import Vue from 'vue'
import VueRouter from 'vue-router'

import SignUpPage from '@/views/account/backup/SignUpPage.vue'
import SignInPage from '@/views/account/backup/SignInPage.vue'
import GitHubSignInPage from '@/views/account/GitHubSignInPage.vue'

Vue.use(VueRouter)

const accountTestRoutes = [
  {
    path: '/sign-up-page',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/sign-in-page',
    name: 'SignInPage',
    component: SignInPage
  },
  {
    path: '/github-sign-in-page',
    name: 'GitHubSignInPage',
    component: GitHubSignInPage
  },
]

export default accountTestRoutes
