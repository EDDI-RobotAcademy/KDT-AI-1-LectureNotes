import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'
import Problem2Page from '@/views/homework/problem2/Problem2Page.vue'
import CarouselTestPage from '@/views/uiVuetify/CarouselTestPage.vue'


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
    path: '/checkbox-test-page',
    name: 'VueCheckboxPage',
    component: VueCheckboxPage
  },
  {
    path: '/multi-checkbox-test-page',
    name: 'VueMultiCheckboxPage',
    component: VueMultiCheckboxPage
  },
  {
    path: '/problem-page2',
    name: 'Problem2Page',
    component: Problem2Page
  },
  {
    path: '/carousel-test-page',
    name: 'CarouselTestPage',
    component: CarouselTestPage
  }
  
  
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
