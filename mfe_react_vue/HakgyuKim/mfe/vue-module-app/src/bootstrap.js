import { createApp } from "vue";

import "./index.css";

import Sample from './domain/Sample.vue';
import store from './store'
import router from './router'

const vueMount = (el) => {
    const app = createApp(Sample).use(store).use(router)
    app.mount(el)
};

const root = document.querySelector('#vue-module')

if (root) { vueMount(root) }

export { vueMount }