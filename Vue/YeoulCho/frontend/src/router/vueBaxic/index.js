import Vue from 'vue'
import VueRouter from 'vue-router'

import VueDataBindingPage from '@/views/basics/binding/VueDataBindingPage.vue'
import VueClickEventPage from '@/views/basics/event/VueClickEventPage.vue'
import VueInputEventPage from '@/views/basics/event/VueInputEventPage.vue'

//네이밍 이슈 존재 (왜 v-model 에 대한 것을 두 번 표현 했는가)
import DuplexWithModelpage from '@/views/basics/vmodel/DuplexWithModelPage.vue'
import VueCheckboxpage from '@/views/basics/vmodel/VueCheckboxPage.vue'
import VueMultiCheckboxpage from '@/views/basics/vmodel/VueMultiCheckboxPage.vue'
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
        name: 'DuplexWithModelpage',
        component: DuplexWithModelpage
      },
      {
        path: '/checkbox-test-page',
        name: 'VueCheckboxpage',
        component: VueCheckboxpage
      },
      {
        path: '/multi-checkbox-test-page',
        name: 'VueMultiCheckboxpage',
        component: VueMultiCheckboxpage
      },
 


]



export default vueBasicRoutes
