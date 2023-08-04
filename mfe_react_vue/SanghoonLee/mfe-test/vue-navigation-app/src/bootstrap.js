import { createApp, h } from "vue";

import "../public/index.scss";

import VueNavigationBarApp from "./VueNavigationBarApp.vue";

import { loadFonts } from "./plugin/webfontloader";

import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
import { createVuetify } from "vuetify";
// import authEventBus from "vueAuthApp/AuthEventBus";

import store from "./store";

let app = null

const navigationMount = (el, eventBus) => {

    loadFonts()
    
    const vuetify = createVuetify({
        components, directives
    })

    app = createApp({
        render: () => h(VueNavigationBarApp, { eventBus })
    })

    app.use(store)
    app.use(vuetify)
    app.provide('eventBus', eventBus);
    //app.provide('authEventBus', authEventBus)
    app.mount(el)
};

const root = document.querySelector('#vue-navigation')

const eventBus = {
    listeners: {},

    on(eventName, callback) {
        if (!this.listeners[eventName]) {
            this.listeners[eventName] = [];
        }
        this.listeners[eventName].push(callback);
    },

    off(eventName, callback) {
        if (!this.listeners[eventName]) {
            return;
        }
        const index = this.listeners[eventName].indexOf(callback);
        if (index !== -1) {
            this.listeners[eventName].splice(index, 1);
        }
    },

    emit(eventName, data) {
        if (!this.listeners[eventName]) {
            return;
        }
        this.listeners[eventName].forEach((callback) => {
            callback(data);
        });
    },
};

if (root) { navigationMount(root, eventBus) }

export { navigationMount }