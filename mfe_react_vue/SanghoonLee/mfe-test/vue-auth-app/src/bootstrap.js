import { createApp } from "vue";

import "./index.css";

import App from "./App.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify } from "vuetify/lib/framework.mjs";

import authenticationModule from './store/index'

import router from './router'

import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/styles'

router.beforeEach((to, from, next) => {
    // 네비게이션 가드 로직
    console.log('Global navigation guard')
    next()
  })

const vuetifyMemberAuthAppMount = (el) => {
    console.log('always mount here')
    loadFonts().then(() => {
        const vuetify = createVuetify({
            components: {
                ...components,
                ...labsComponents,
            },
            directives: {
                ...directives,
            }
        })
    
        const app = createApp(App).use(vuetify)
        app.use(authenticationModule).use(router)
        app.mount(el)
    })
};

const root = document.querySelector('#vue-auth-app')

if (root) { vuetifyMemberAuthAppMount(root) }

export { vuetifyMemberAuthAppMount }