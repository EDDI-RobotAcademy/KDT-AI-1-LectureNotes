import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import VuetifyBoardList from '../page/VuetifyBoardList.vue'
import VuetifyBoardRegister from "../page/VuetifyBoardRegister.vue"
import VuetifyBoardRead from "../page/VuetifyBoardRead.vue"

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
    {
        path: '/vuetify-board-read/:boardId',
        name: 'VuetifyBoardRead',
        components: { default: VuetifyBoardRead },
        props: { default: true },
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router