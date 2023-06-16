// 내가 보고 적절하게 분배할 것

import Vue from 'vue'
import VueRouter from 'vue-router'

import ProblemPage2 from '@/views/homework/problem2/ProblemPage2.vue'

import HiSendTestPage from '@/views/basics/axios/HiSendTestPage.vue'
import HiResponsePage from '@/views/basics/axios/HiResponsePage.vue'

import FruitPriceSum from '@/views/homework/buyFruits/FruitPriceSum.vue'

import VueSpring from '@/views/homework/vueSpringFastApi/VueSpring.vue'

import KerasTest from '@/views/homework/vueFastapiKeras/KerasTest.vue'

Vue.use(VueRouter)

const prolblemsRoutes = [
    {
        path: '/homework2',
        name: 'ProblemPage2',
        component: ProblemPage2
    },
    {
        path: '/hi-send-test',
        name: 'HiSendTestPage',
        component: HiSendTestPage
    },
    {
        path: '/hi-response-test',
        name: 'HiResponsePage',
        component: HiResponsePage
    },
    {
        path: '/fruit-price-sum',
        name: 'FruitPriceSum',
        component: FruitPriceSum
    },
    {
        path: '/vue-spring',
        name: 'VueSpring',
        component: VueSpring
    },
    {
        path: '/fastapi-keras',
        name: 'KerasTest',
        component: KerasTest
    },
]

export default prolblemsRoutes