import { createApp } from "vue";

import "./index.scss";

import App from "./App.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify, VuetifyOptions } from "vuetify/lib/framework.mjs";

// for use(storeModule)
import boardModule from './store/index'

import router from './router'

const vuetifyTailwindBoardAppMount = (el: string | Element) => {
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
    
        const app = createApp(App).use(vuetify).use(boardModule).use(router)
        app.mount(el)
    })
};

const root = document.querySelector('#vuetify-tailwind-board-app')

if (root) { vuetifyTailwindBoardAppMount(root) }

export { vuetifyTailwindBoardAppMount }
