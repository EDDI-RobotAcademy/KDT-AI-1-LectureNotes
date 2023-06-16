import { createApp } from "vue";

import "./index.css";

import Sample from "./domain/Sample.vue";

const mount = (el) => {
  const app = createApp(Sample);
  app.mount(el);
};

const root = document.querySelector("#vue-module");

if (root) {
  mount(root);
}

export { mount };
