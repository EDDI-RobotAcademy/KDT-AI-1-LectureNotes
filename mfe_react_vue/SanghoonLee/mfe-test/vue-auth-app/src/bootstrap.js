import { createApp, h } from "vue";

import "./index.css";

import VueAuthApp from "./VueAuthApp.vue";

import { loadFonts } from "./plugins/webfontloader";

import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import * as labsComponents from 'vuetify/labs/components'

import { createVuetify } from "vuetify/lib/framework.mjs";

import authenticationModule from './store/index'

import router from './router'

import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/dist/vuetify.min.css'
import 'vuetify/styles'
import authEventBus from "./utility/ipc/authEventBus";

// router.beforeEach((to, from, next) => {
//     // 네비게이션 가드 로직
//     console.log('Global navigation guard')
//     next()
//   })

const vuetifyMemberAuthAppMount = (el, eventBus) => {
    console.log('always mount here')
    loadFonts().then(() => {
        const vuetify = createVuetify({
            components: {
                ...components,
                ...labsComponents,
            },
            directives: {
                ...directives,
            }
        })
    
        //const app = createApp(VueAuthApp).use(vuetify)

        const app = createApp({
            render: () => h(VueAuthApp, { eventBus })
        })
    
        app.use(vuetify).provide("eventBus", eventBus)
        app.provide("authEventBus", authEventBus)
        console.log('Navigation Bar App - authEventBus: ' + authEventBus)

        app.use(authenticationModule).use(router)
        app.mount(el)
    })
};

// TODO: Remotes Auth App에 저장된 localStorage 정보를 Container가 볼 수 있어야함
// 가만 보니까 구지 ? 그냥 여기 localStorage가 가지고 있으면 여기서 처리하고 이벤트 발행하는게 더 낫지 않나 ?
const eventBus = {
    listeners: {},

    on(eventName, callback) {
        console.log("일단 꼼수다 - 그냥 여기서도 리다이렉션으로 Container 갖다 박어!")
        // if (!this.listeners[eventName]) {
        //     this.listeners[eventName] = [];
        // }
        // this.listeners[eventName].push(callback);
        window.location.href = "http://localhost:3000/"
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
        // check!
        // 실제로 Container에서 받아온 EventBus가 사용되어야 하는데
        // 단독으로 동작할 때 사용하는 EventBus가 사용되어 Container에 Event Issuing이 안되고 있음
        console.log('리다이렉션 때문에 니가 실행되니 ?')
        if (!this.listeners[eventName]) {
            return;
        }
        this.listeners[eventName].forEach((callback) => {
            callback(data);
        });
    },
};

const root = document.querySelector('#vue-auth-app')

// AuthApp은 단독으로 동작할 때도 EventBus를 React Container 것을 사용하도록 보장해줘야함
// 차라리 EventBus 전용 서비스를 별개로 구성하는 것도 나쁘지 않을 것임
if (root) { vuetifyMemberAuthAppMount(root, eventBus) }

export { vuetifyMemberAuthAppMount }