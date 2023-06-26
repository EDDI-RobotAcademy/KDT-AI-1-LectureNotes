import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router" 

import VuetifyBoardList from '../page/VuetifyBoardList.vue'
import VuetifyBoardRigister from '../page/VuetifyBoardRegister.vue'
import VuetifyBoardRead from '../page/VuetifyBoardRead.vue'
const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'VuetifyBoardList',
        component: VuetifyBoardList,
    },
    {
        path: '/vuetify-board-register',
        name: 'VuetifyBoardRegister',
        component: VuetifyBoardRigister,
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