import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

import VuetifyBoardList from "../page/VuetifyBoardList.vue"
import VuetifyBoardRegister from "../page/VuetifyBoardRegister.vue"
import VuetifyBoardRead from "../page/VuetifyBoardRead.vue"
import VuetifyBoardModify from "../page/VuetifyBoardModify.vue"

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'VuetifyBoardList',
        component: VuetifyBoardList
    },
    {
        path: '/vuetify-board-register',
        name: 'VuetifyBoardRegister',
        component: VuetifyBoardRegister
    },
    {
        path: '/vuetify-board-read/:boardId',
        name: 'VuetifyBoardRead',
        components: { default: VuetifyBoardRead },
        props: { default: true },
    },
    {
        path: '/vuetify-board-modify/:boardId',
        name: 'VuetifyBoardModify',
        components: { default: VuetifyBoardModify },
        props: { default: true },
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;