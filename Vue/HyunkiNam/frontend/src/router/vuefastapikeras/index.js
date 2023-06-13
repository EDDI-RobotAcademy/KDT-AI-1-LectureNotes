import Vue from 'vue'
import VueRouter from 'vue-router'

import VueFastAPIKerasPage from '@/views/homework/VueFastAPIKerasPage.vue'

Vue.use(VueRouter)

const vuefastapikerasRoutes = [
    {
        path: '/vue-fastapi-keras-page',
        name: 'VueFastAPIKerasPage',
        component: VueFastAPIKerasPage
    },
]

export default vuefastapikerasRoutes