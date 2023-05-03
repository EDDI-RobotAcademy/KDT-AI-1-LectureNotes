import VueRouter from "vue-router";
import Vue from "vue";

import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvancedPage from "@/views/uiVuetify/TableAdvancedPage.vue";
import ImageGalleryTest from "@/views/uiVuetify/ImageGalleryTest.vue";
import PrintImageTest from "@/views/uiVuetify/PrintImageTest.vue";

Vue.use(VueRouter)
const vuetifyTestRoutes = [
    {
        path: '/table-test-page',
        name: 'TableTestPage',
        component: TableTestPage
    },
    {
        path: '/table-advanced-Page',
        name: 'TableAdvancedPage',
        component: TableAdvancedPage
    },
    {
        path: '/image-gallery-test',
        name: 'ImageGalleryTest',
        component: ImageGalleryTest
    },
    {
        path: '/print-image-test',
        name: 'PrintImageTest',
        component: PrintImageTest
    }
]

export default vuetifyTestRoutes