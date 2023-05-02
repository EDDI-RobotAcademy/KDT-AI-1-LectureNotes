import Vue from 'vue'
import VueRouter from 'vue-router'

import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'

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
  }


]

export default vuetifyTestRoutes