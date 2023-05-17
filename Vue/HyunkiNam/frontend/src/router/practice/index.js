import Vue from 'vue'
import VueRouter from 'vue-router'
// @는 현재 src 폴더를 의미함
import PracticePage from '@/views/practice/PracticePage.vue'
import KakaoAPIPage from '@/views/practice/KakaoAPIPage.vue'

Vue.use(VueRouter)

const practiceRoutes = [
    {
        path: '/practice-page',
        name: 'PracticePage',
        component: PracticePage
    },
    {
        path: '/kakao-api-page',
        name: 'KakaoAPIPage',
        component: KakaoAPIPage
    },
]

export default practiceRoutes