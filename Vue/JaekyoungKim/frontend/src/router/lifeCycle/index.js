import Vue from 'vue'
import VueRouter from 'vue-router'
import VueLifeCycleTestPage from '@/views/basics/lifeCycle/VueLifeCycleTestPage.vue'

Vue.use(VueRouter)

const lifeCycleRoutes = [
  {
    path: '/life-cycle-test',
    name: 'VueLifeCycleTestPage',
    component: VueLifeCycleTestPage
  },


]

export default lifeCycleRoutes
