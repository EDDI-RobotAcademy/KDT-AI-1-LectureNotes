import Vue from 'vue'
import VueRouter from 'vue-router'

import FileHandlerPage from '@/views/files/FileHandlerPage.vue'

Vue.use(VueRouter)

const filesTestRoutes = [
    {
        path: '/file-handler-test-page',
        name: 'FileHandlerPage',
        component: FileHandlerPage
    },

]

export default filesTestRoutes