import VueRouter from "vue-router";
import Vue from "vue";

import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvancedPage from "@/views/uiVuetify/TableAdvancedPage.vue";

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
    }
]

export default vuetifyTestRoutes