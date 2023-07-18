import { createSSRApp, h } from 'vue';
import NuxtStartApp from './NuxtBasicApp.vue';

export const mountTestComponent = (container) => {
  const app = createSSRApp({
    render: () => h(NuxtStartApp),
  });

  app.mount(container);
};

if (root) { mount(root, eventBus); }

export { mount, routingPath }