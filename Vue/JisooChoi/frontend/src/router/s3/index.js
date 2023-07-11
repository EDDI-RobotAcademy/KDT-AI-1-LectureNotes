import Vue from 'vue'
import VueRouter from 'vue-router'
import s3test from '@/views/s3/s3test.vue'

Vue.use(VueRouter)

const s3Routes = [
  {
    path: '/s3-page',
    name: 's3test',
    component: s3test
  },
]

export default s3Routes