import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함

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