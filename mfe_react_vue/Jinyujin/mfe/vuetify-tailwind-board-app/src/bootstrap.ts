import { createApp } from "vue";

import "./index.scss";

import App from "./App.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify, VuetifyOptions } from "vuetify/lib/framework.mjs";

// for use(storeModule)
// import board@Module from './store/index'

import router from './router'

// vuetifyTailwindBoardAppMount함수는 el파라미터로 문자열이나 Element 객체를 받아와서 실행
// Element 객체란?
// 좀 어려운데 문서상의 각각의 태그(엘리먼트)의 내용들을 추상화한 객체 - 쌤한테 물어보기
const vuetifyTailwindBoardAppMount = (el: string | Element) => {
    const vuetify = createVuetify({
        // createVuetify 함수를 사용하여 vuetify 객체 생성
        components: {
            ...components,
            ...labsComponents
        },
        directives: {
            ...directives
        }
    })

    const app = createApp(App).use(vuetify).use(router)
    // createApp 함수를 사용하여 Vue 애플리케이션 객체 생성
    app.mount(el)
    // 생성한 애플리케이션 객체에 
};

const root = document.querySelector('#vuetify-tailwind-board-app')

if (root) { vuetifyTailwindBoardAppMount(root) }

export { vuetifyTailwindBoardAppMount }