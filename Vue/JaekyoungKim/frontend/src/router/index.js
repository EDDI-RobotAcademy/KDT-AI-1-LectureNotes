import Vue from 'vue'
import VueRouter from 'vue-router'

import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'
import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'
import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import April from '@/views/html/April.vue'
import PhotoPage from '@/views/photo/Photo.vue'
import vuetifyTestRoutes from './uiVuetify'
import productTestRoutes from './product'
import axiosTestRoutes from './axiosTest'
import boardTestRoutes from './board'
import problemsRoutes from './problems'
import vModelRoutes from './vModel'
import defaultRoutes from './defaultRouterSet'
import PlotTestRoutes from './Plot'
import FileTestRoutes from './file'
import foodSetRoutes from './food'
import ReFirstProblem from '@/views/reProblem/ReFirstProblem.vue'
import ReSecondProblem from '@/views/reProblem/ReSecondProblem.vue'
import fastApiTestRoutes from './fastapi'
import accountTestRoutes from './account'
import authenticationTestRoutes from './authentication'
Vue.use(VueRouter)

const routes = [

  {
    path: '/htmlTest',
    name: 'HtmlTest',
    component: HtmlTest
  },
  {
    path: '/cssTest',
    name: 'CssTest',
    component: CssTest
  },
  {
    path: '/basics/binding',
    name: 'VueDataBinidngPage',
    component: VueDataBindingPage
  },
  {
    path: '/basics/event',
    name: 'VueClickEventPage',
    component: VueClickEventPage
  },
  {
    path: '/vue-input-event-page',
    name: 'VueInputEventPage',
    component: VueInputEventPage
  },
  
  {
    path: '/global-component-test-page',
    name: 'ComponentTestPage',
    component: ComponentTestPage
  },
{
  path: '/april',
  name: 'April',
  component: April
},
{
  path: '/photo-page',
  name: 'PhotoPage',
  component: PhotoPage
},
{
  path:'/re-problem-page',
  name:'ReFirstProblem',
  component:ReFirstProblem

},
{
  path:'/re-second-page',
  name:'ReSecondProblem',
  component:ReSecondProblem

},

 ...vuetifyTestRoutes,
 ...productTestRoutes,
 ...axiosTestRoutes,
 ...boardTestRoutes,
 ...problemsRoutes,
 ...vModelRoutes,
 ...defaultRoutes,
 ...PlotTestRoutes,
 ...FileTestRoutes,
 ...foodSetRoutes,
 ...fastApiTestRoutes,
 ...accountTestRoutes,
 ...authenticationTestRoutes,
]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
