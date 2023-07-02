import {createApp, h, onUnmounted} from "vue";

import "./index.css";

import Sample from './domain/Sample.vue';
import store from './store'
import router from './router'

let app = null

const mount = (el, eventBus) => {
    console.log('vue-board-app bootstrap으로 EventBus 전달!')
    app = createApp({
        render: () => h(Sample, { eventBus })
    })

    app.use(store).use(router)
    app.provide("eventBus", eventBus);
    app.mount(el)

    onUnmounted(() => {
        app.unmount();
        app = null;
    });
};

const routingPath = (el, path, boardId = null) => {
    if (app) {
        app.unmount();
        console.log('unmount 동작 - app: ' + app);
    }

    app = createApp(Sample).use(store).use(router)
    app.mount(el)
    console.log('app 다시 붙이기 동작 - app: ' + app)

    router.push(path)
}

const root = document.querySelector('#vue-module')

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

if (root) { mount(root, eventBus); }

export { mount, routingPath }