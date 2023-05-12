import Vue from 'vue'
import VueRouter from 'vue-router'

import FileHandlerPage from '@/views/file/FileHandlerPage.vue'
import FileListShowPage from '@/views/file/FileListShowPage.vue'

Vue.use(VueRouter)

const filesTestRoutes = [
  {
    path: '/file-handler-test-page',
    name: 'FileHandlerPage',
    component: FileHandlerPage
  },
  {
    path: '/file-list-show-page',
    name: 'FileListShowPage',
    component: FileListShowPage
  },
  
]

export default filesTestRoutes
