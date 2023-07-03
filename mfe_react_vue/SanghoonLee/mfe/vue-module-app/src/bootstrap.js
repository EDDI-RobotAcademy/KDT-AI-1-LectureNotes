import { createApp } from "vue";

import "./index.css";

import Sample from './domain/Sample.vue';
import store from './store'
import router from './router'

let app = null

const mount = (el) => {
    app = createApp(Sample).use(store).use(router)
    app.mount(el)
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

if (root) { mount(root) }

export { mount, routingPath }