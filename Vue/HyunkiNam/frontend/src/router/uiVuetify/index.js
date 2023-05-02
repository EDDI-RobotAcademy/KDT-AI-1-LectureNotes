import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'

Vue.use(VueRouter)

const vuetifyTestRoutes = [
    {
        path: '/vuetify-table-test',
        name: 'TableTestPage',
        component: TableTestPage
    }
]

export default vuetifyTestRoutes