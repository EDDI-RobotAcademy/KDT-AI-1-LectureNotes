import { createApp } from "vue";

import "./index.scss";

import App from "./App.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify, VuetifyOptions } from "vuetify/lib/framework.mjs";
import vuetify from "./plugins/vuetify";

// for use(storeModule)
// import boardModule from './store/index'

import router from './router'

const vuetifyTailwindBoardAppMount = (el: string | Element) => {
  const vuetify = createVuetify({
    components: {
      ...components,
      ...labsComponents,
    },
    directives: {
      ...directives
    }
  })

  const app = createApp(App).use(vuetify).use(router)
  app.mount(el)
};

const root = document.querySelector('#vuetify-tailwind-board-app')
// JavaScript에서 document.querySelector 메서드를 사용하여 DOM(Document Object Model)에서 
// ID가 vuetify - tailwind - board - app인 요소를 찾는 부분입니다.

if (root) { vuetifyTailwindBoardAppMount(root) }


export { vuetifyTailwindBoardAppMount }