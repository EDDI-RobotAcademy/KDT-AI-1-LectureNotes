import Vue from 'vue'
import VueRouter from 'vue-router'
import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'
import ImageGalleryTest from '@/views/uiVuetify/ImageGalleryTest.vue'
import PrintImageTest from '@/views/uiVuetify/PrintImageTest.vue'

Vue.use(VueRouter)

const vuetifyTestRoutes = [
  {
    path: '/vuetify-table-test',
    name: 'TableTestPage',
    component: TableTestPage
  },
  {
    path: '/table-advanced-test',
    name: 'TableAdvanced',
    component: TableAdvanced
  },  {
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
