import Vue from 'vue'
import VueRouter from 'vue-router'

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