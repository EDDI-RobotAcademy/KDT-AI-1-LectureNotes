import { createApp, h, onUnmounted } from "vue";

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

let app: typeof App

const vuetifyTailwindBoardAppMount = (el: string | Element, eventBus: any) => {
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
    
        app = createApp({
            render: () => h(App, { eventBus })
        })
        app.use(vuetify).use(boardModule).use(router)
        app.provide('eventBus', eventBus);
        app.mount(el)

        onUnmounted(() => {
            app.unmount();
            app = null;
        });
    })
};

interface EventBus {
    listeners: { [eventName: string]: Function[] };
    on(eventName: string, callback: Function): void;
    off(eventName: string, callback: Function): void;
    emit(eventName: string, data: any): void;
}

const eventBus: EventBus = {
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
}

const root = document.querySelector('#vuetify-tailwind-board-app')

if (root) { vuetifyTailwindBoardAppMount(root, eventBus) }

export { vuetifyTailwindBoardAppMount }
