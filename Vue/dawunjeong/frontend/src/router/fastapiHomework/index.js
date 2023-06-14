import Vue from 'vue'
import VueRouter from 'vue-router'

import FastApiHomeworkPage from '@/views/fastapiHomework/FastApiHomeworkPage.vue'

Vue.use(VueRouter)

const fastApiHomeworkRoutes = [
  {
    path: '/fastapi-homework-page',
    name: 'FastApiHomeworkPage',
    component: FastApiHomeworkPage
  },
]

export default fastApiHomeworkRoutes