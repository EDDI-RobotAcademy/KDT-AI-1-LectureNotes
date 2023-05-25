import Vue from 'vue'
import VueRouter from 'vue-router'

import VueSpring from '@/views/homework/vueSpringFastApi/VueSpring.vue'

Vue.use(VueRouter)

const vueSpringRoutes = [
    {
        path: '/vue-spring',
        name: 'VueSpring',
        component: VueSpring
    },
]

export default vueSpringRoutes