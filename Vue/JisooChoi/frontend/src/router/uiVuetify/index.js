import Vue from 'vue'
import VueRouter from 'vue-router'

import TableTestPage from '@/views/uiVuetify/TableTestPage.vue'
import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'
import ImageGalleryTest from '@/views/uiVuetify/ImageGalleryTest.vue'

// Vue 문제 은행 6
import vuetifyImageProbPage from '@/views/basics/homework/vuetifyProb/vuetifyImageProbPage.vue'

import DialogTestPage from '@/views/uiVuetify/DialogTestPage.vue'
import CarouselTestPage from '@/views/uiVuetify/CarouselTestPage.vue'

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
  {
    path: '/vuetify-image-prob-page',
    name: 'vuetifyImageProbPage',
    component: vuetifyImageProbPage
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
]

export default vuetifyTestRoutes