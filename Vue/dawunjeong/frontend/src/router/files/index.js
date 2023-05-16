import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

import FileHandlerPage from '@/views/file/FileHandlerPage.vue'

Vue.use(VueRouter)

const filesTestRoutes = [
  {
    path: '/file-handler-page',
    name: 'FileHandlerPage',
    component: FileHandlerPage
  },
]

export default filesTestRoutes
