import Vue from 'vue'
import VueRouter from 'vue-router'

import WebSocketChatView from '@/views/chat/WebSocketChatView.vue'

Vue.use(VueRouter)

const chatRoutes = [
  {
    path: '/chat',
    name: 'WebSocketChatView',
    component: WebSocketChatView
  },
]

export default chatRoutes
