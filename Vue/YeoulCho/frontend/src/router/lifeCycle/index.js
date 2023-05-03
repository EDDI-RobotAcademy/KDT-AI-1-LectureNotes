import Vue from 'vue'
import VueRouter from 'vue-router'

import VueLifecycleTestPage from '@/views/basics/lifeCycle/VueLifecycleTestPage'

Vue.use(VueRouter)

const vueLifeCycleRoutes = [
  {
    path: '/vue-lifecycle-test',
    name: 'VueLifecycleTestPage',
    component: VueLifecycleTestPage
  },
 


]



export default vueLifeCycleRoutes
