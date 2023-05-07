import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'
import ImageGalleryTest from '@/views/uiVuetify/ImageGalleryTest.vue'

Vue.use(VueRouter)

const vuetifyTestRoutes = [
    {
        path: '/vuetify-table-test',
        name: 'TableTestPage',
        component: TableTestPage
    },
    {
        path: '/vuetify-table-advanced',
        name: 'TableAdvanced',
        component: TableAdvanced
    },
    {
        path: '/vuetify-image-gallery',
        name: 'ImageGalleryTest',
        component: ImageGalleryTest
    },
]

export default vuetifyTestRoutes