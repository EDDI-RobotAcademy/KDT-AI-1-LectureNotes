import VueRouter from "vue-router";
import Vue from "vue";

import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvancedPage from "@/views/uiVuetify/TableAdvancedPage.vue";
import ImageGalleryTest from "@/views/uiVuetify/ImageGalleryTest.vue";
import PrintImageTest from "@/views/uiVuetify/PrintImageTest.vue";
import DialogTestPage from "@/views/uiVuetify/DialogTestPage.vue";
import CarouselTestPage from "@/views/uiVuetify/CarouselTestPage.vue";
import D3PlotTestPage from "@/views/plot/D3PlotTestPage.vue";
import D3HealthPrintPage from "@/views/plot/D3HealthPrintPage.vue";

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
    },
    {
        path: '/dialog-test-page',
        name: 'DialogTestPage',
        component: DialogTestPage
    },
    {
        path: '/carousel-test-page',
        name: 'CarouselTestPage',
        component: CarouselTestPage
    },
    {
        path: '/d3plot-test-page',
        name: 'D3PlotTestPage',
        component: D3PlotTestPage
    },
    {
        path: '/d3-health-print-page',
        name: 'D3HealthPringPage',
        component: D3HealthPrintPage
    }
]

export default vuetifyTestRoutes