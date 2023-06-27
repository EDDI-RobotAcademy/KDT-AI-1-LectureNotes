import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import VuetifyBoardList from '../page/VuetifyBoardList.vue'
import VuetifyBoardRegister from "../page/VuetifyBoardRegister.vue"

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'VuetifyBoardList',
        component: VuetifyBoardList
        // components라고 하면 안됨!
    },
    {
        path: '/vuetify-board-register',
        name: 'VuetifyBoardRegister',
        component: VuetifyBoardRegister,
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router