import {createApp, h, ref} from "vue";

import "./index.css";

import App from "./App.vue";

let app = null

const mount = (el, eventBus) => {
    console.log('eventBus: ' + eventBus)
    app = createApp({
        render: () => h(App, { eventBus })
    })

    app.provide("eventBus", eventBus);
    app.mount(el)
};

const root = document.querySelector('#vue-module-app')

// const eventBus = {
//     listeners: {},
//
//     on(eventName, callback) {
//         if (!this.listeners[eventName]) {
//             this.listeners[eventName] = [];
//         }
//         this.listeners[eventName].push(callback);
//     },
//
//     off(eventName, callback) {
//         if (!this.listeners[eventName]) {
//             return;
//         }
//         const index = this.listeners[eventName].indexOf(callback);
//         if (index !== -1) {
//             this.listeners[eventName].splice(index, 1);
//         }
//     },
//
//     emit(eventName, data) {
//         if (!this.listeners[eventName]) {
//             return;
//         }
//         this.listeners[eventName].forEach((callback) => {
//             callback(data);
//         });
//     },
// };

//if (root) { mount(root, eventBus); }
if (root) { mount(root); }

export { mount }
