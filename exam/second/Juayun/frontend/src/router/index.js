import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import CheckBox from '@/views/exam/CheckBox.vue'
import HiPage from '@/views/exam/HiPage.vue'
import OptionPage from '@/views/exam/OptionPage.vue'
import RoleDicePage from '@/views/exam/dice/RoleDicePage.vue'
import CarouselTestPage from '@/views/exam/image/CarouselTestPage.vue'
import ImageGalleryTest from '@/views/exam/image/ImageGalleryTest.vue'
import BusinessAccountPage from '@/views/exam/account/BusinessAccountPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/check-box-page',
    name: 'CheckBox',
    component: CheckBox
  },
  {
    path: '/hi-page',
    name: 'HiPage',
    component: HiPage
  },
  {
    path: '/option-page',
    name: 'OptionPage',
    component: OptionPage
  },
  {
    path: '/role-dice-page',
    name: 'RoleDicePage',
    component: RoleDicePage
  },
  {
    path: '/carousel-test-page',
    name: 'CarouselTestPage',
    component: CarouselTestPage
  },
  {
    path: '/image-test-page',
    name: 'ImageGalleryTest',
    component: ImageGalleryTest
  },
  {
    path: '/business-account-test-page',
    name: 'BusinessAccountPage',
    component: BusinessAccountPage
  },
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
