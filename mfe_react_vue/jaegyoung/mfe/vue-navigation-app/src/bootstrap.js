import { createApp } from "vue";

import "../public/index.scss";

import App from "./App.vue";

import { loadFonts } from "./plugin/webfontloader";

import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
import { createVuetify } from "vuetify";

const navigationMount = (el) => {

    loadFonts()
    
    const vuetify = createVuetify({
        components, directives
    })

    const app = createApp(App).use(vuetify)
    app.mount(el)
};

const root = document.querySelector('#vue-navigation')

if (root) { navigationMount(root) }

export { navigationMount }