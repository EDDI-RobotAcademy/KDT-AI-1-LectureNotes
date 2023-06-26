import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

import VuetifyBoardList from '../page/VuetifyBoardList.vue'
import VuetifyBoardRegister from '../page/VuetifyBoardRegister.vue'
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
        component: VuetifyBoardRegister,
    },
    {   // props가 있고, 멀티 컴포넌트의 형태이다.
        // 가변인자 처리도 잊지말자
        path: '/vuetify-board-read/:boardId',
        name: 'VuetifyBoardRead',
        components: {default: VuetifyBoardRead},
        props: {default: true},
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router