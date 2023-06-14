import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import CheckboxPage from '@/views/checkbox/CheckboxPage.vue'
import GetRequestPage from '@/views/getRequest/GetRequestPage.vue'
import SelectOpitionPage from '@/views/selectOption/SelectOpitionPage.vue'
import DiceResponsePage from '@/views/diceResponse/DiceResponsePage.vue'
import ImageGalleryPage from '@/views/imageGallery/ImageGalleryPage.vue'
import ImageCarouselPage from '@/views/imageGallery/ImageCarouselPage.vue'
import DomainServicePage from '@/views/domainService/DomainServicePage.vue'
import SignInPage from '@/views/signIn/SignInPage.vue'
import EarningPointsToWriteTestPage from '@/views/earningPointsToWriteTest/EarningPointsToWriteTestPage.vue'
import EarnigPointsToUseModuleInVuex from '@/views/earnigPointsToUseModuleInVuex/EarnigPointsToUseModuleInVuex.vue'


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
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/checkbox-page',
    name: 'CheckboxPage',
    component: CheckboxPage
  },
  {
    path: '/get-request-page',
    name: 'GetRequestPage',
    component: GetRequestPage
  },
  {
    path: '/select-option-page',
    name: 'SelectOpitionPage',
    component: SelectOpitionPage
  },
  {
    path: '/dice-response-page',
    name: 'DiceResponsePage',
    component: DiceResponsePage
  },
  {
    path: '/image-gallery-page',
    name: 'ImageGalleryPage',
    component: ImageGalleryPage
  },
  {
    path: '/image-carousel-page',
    name: 'ImageCarouselPage',
    component: ImageCarouselPage
  },
  {
    path: '/domain-service-page',
    name: 'DomainServicePage',
    component: DomainServicePage
  },
  {
    path: '/sign-in-page',
    name: 'SignInPage',
    component: SignInPage
  },
  {
    path: '/earning-points-to-write-test',
    name: 'EarningPointsToWriteTestPage',
    component: EarningPointsToWriteTestPage
  },
  {
    path: '/earning-points-to-use-module-in-vuex',
    name: 'EarnigPointsToUseModuleInVuex',
    component: EarnigPointsToUseModuleInVuex
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
