import {createApp, h, onUnmounted} from "vue";

import "./index.css";

import App from "./App.vue";

let app = null

const mountCounterContainer = (el, eventBus) => {
    console.log('vue-counter-app bootstrap으로 EventBus 전달!')
    app = createApp({
        render: () => h(App, { eventBus })
    })

    app.provide("eventBus", eventBus);
    app.mount(el)

    onUnmounted(() => {
        app.unmount();
        app = null;
    });
};

const root = document.querySelector('#vue-counter-container')

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

if (root) { mountCounterContainer(root, eventBus); }

export { mountCounterContainer }