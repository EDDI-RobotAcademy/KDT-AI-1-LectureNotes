import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import VuetifyBoardList from '../page/VuetifyBoardList.vue'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'VuetifyBoardList',
        component: VuetifyBoardList
        // components라고 하면 안됨!
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router