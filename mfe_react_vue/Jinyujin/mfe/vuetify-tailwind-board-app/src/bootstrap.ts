import { createApp } from "vue";

import "./index.scss";

import App from "./App.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify, VuetifyOptions } from "vuetify/lib/framework.mjs";

// for use(storeModule)

import router from './router'
import boardModule from "./store/index";

// vuetifyTailwindBoardAppMount함수는 el파라미터로 문자열이나 Element 객체를 받아와서 실행
// Element 객체란?
// 좀 어려운데 문서상의 각각 요소(element)의 내용들을 추상화한 객체 
const vuetifyTailwindBoardAppMount = (el: string | Element) => {
    // 마운트하여 화면에 표시하는 역할을 하는 코드
    // 문자열 또는 요소를 매개변수로 받아들임
    loadFonts().then(() => {
        // loadFonts(): 마운트하기 전에 폰트를 로드하는 역할
        const vuetify = createVuetify({
            // createVuetify 함수를 사용하여 vuetify 객체 생성
            components: {
                ...components,
                ...labsComponents
                // 여기서 ...은 맵핑시켜주는 것 
                // 이렇게하면 components의 요소들 + labsComponents의 요소들이 
                // 한꺼번에 상위 components의 요소가 된다 
            },
            directives: {
                ...directives
            }
        })

        const app = createApp(App).use(vuetify).use(boardModule).use(router)
        // createApp 함수를 사용하여 Vue 애플리케이션 객체 생성
        app.mount(el)
        // 생성한 app을 el을 매개변수로 하여 mount함
    })
};

const root = document.querySelector('#vuetify-tailwind-board-app')
// querySelector: id가 vuetify-tailwind-board-app인 요소를 찾음

if (root) { vuetifyTailwindBoardAppMount(root) }
// root 요소가 존재한다면 vuetifyTailwindBoardAppMount함수를 실행

export { vuetifyTailwindBoardAppMount }
// vuetifyTailwindBoardAppMount 함수를 외부에서 사용할 수 있도록 export함