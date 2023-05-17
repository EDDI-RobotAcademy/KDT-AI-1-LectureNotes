import Vue from 'vue'
import VueRouter from 'vue-router'

import HtmlTest from '@/views/html/HtmlTest.vue'
import CssTest from '@/views/css/CssTest.vue'

Vue.use(VueRouter)

const htmlCssRoutes = [
    {
        path: '/htmlTest',
        name: 'HtmlTest',
        component: HtmlTest
      },
      {
        path: '/cssTest',
        name: 'CssTest',
        component: CssTest
      },


]



export default htmlCssRoutes
