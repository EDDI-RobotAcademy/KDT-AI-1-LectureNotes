import Vue from 'vue'
import VueRouter from 'vue-router'

import ComponentTestpage from '@/views/basics/componentTest/ComponentTestPage.vue'
import AddComponentPage from '@/views/homework/AddComponentPage.vue'

Vue.use(VueRouter)

const componentTestRoutes = [
    {
        path: '/global-component-test-page',
        name: 'ComponentTestpage',
        component: ComponentTestpage
      },
      
      {
        path: '/component-homework-test-page',
        name: 'AddComponentPage',
        component: AddComponentPage
      },


]



export default componentTestRoutes
