import Vue from 'vue'
import VueRouter from 'vue-router'

import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'

import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

// 네이밍 이슈 존재 (왜 v-model에 대한 것을 두 번 표현 했는가)
import DuplexWithModelPage from '@/views/basics/vModel/DuplexWithModelPage.vue'
import VueCheckboxPage from '@/views/basics/vModel/VueCheckboxPage.vue'
import VueMultiCheckboxPage from '@/views/basics/vModel/VueMultiCheckboxPage.vue'

Vue.use(VueRouter)

const vueBasicRoutes = [
    {
        path: '/vue-data-binding-page',
        name: 'VueDataBindingPage',
        component: VueDataBindingPage
    },
    {
        path: '/vue-click-event-page',
        name: 'VueClickEventPage',
        component: VueClickEventPage
    },
    {
        path: '/vue-input-event-page',
        name: 'VueInputEventPage',
        component: VueInputEventPage
    },
    {
        path: '/duplex-model-test-page',
        name: 'DuplexWithModelPage',
        component: DuplexWithModelPage
    },
    {
        path: '/checkbox-test-page',
        name: 'VueCheckboxPage',
        component: VueCheckboxPage
    },
    {
        path: '/multi-checkbox-test-page',
        name: 'VueMultiCheckboxPage',
        component: VueMultiCheckboxPage
    },
]

export default vueBasicRoutes