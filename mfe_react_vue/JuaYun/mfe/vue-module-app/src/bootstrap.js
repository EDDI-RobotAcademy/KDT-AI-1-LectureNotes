import { createApp } from "vue";

import "./index.css";

import Sample from './domain/Sample.vue';
import store from './store'

const mount = (el) => {
    const app = createApp(Sample).use(store)
    app.mount(el)
};

const root = document.querySelector('#vue-module')

if (root) { mount(root) }

export { mount }