import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Problem14 from '@/views/Test/Problem14.vue'
import Problem20 from '@/views/Test/Problem20.vue'
import Problem23 from '@/views/Test/Problem23.vue'

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
    path: '/problem-14',
    name:'Problem14',
    component:Problem14
  
  },
  { 
    path: '/problem-20',
    name:'Problem20',
    component:Problem20
  
  },
  { 
    path: '/problem-23',
    name:'Problem23',
    component:Problem23
  
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
