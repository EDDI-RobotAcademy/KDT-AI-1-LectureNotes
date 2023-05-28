import Vue from 'vue'
import VueRouter from 'vue-router'

import ComponentTestPage from '@/views/basics/componentTest/ComponentTestPage.vue'
import GlobalComponent from '@/views/homeworks/globaComponent/GlobalComponent.vue'
import LocalComponent from '@/views/homeworks/localComponent/LocalComponent.vue'

Vue.use(VueRouter)

const vuetifyTestRoutes  = [
  {
    path: '/global-component-test-page',
    name: 'ComponentTestPage',
    component: ComponentTestPage
  },
  
  {
    path: '/global-component',
    name: 'GlobalComponent',
    component: GlobalComponent
  },
  {
    path: '/local-component',
    name: 'LocalComponent',
    component: LocalComponent
  },

]

export default vuetifyTestRoutes