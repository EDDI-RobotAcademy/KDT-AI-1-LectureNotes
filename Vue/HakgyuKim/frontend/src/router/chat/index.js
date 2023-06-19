import Vue from 'vue'
import VueRouter from 'vue-router'

import WebSocketChatPage from "@/views/chat/WebSocketChatView.vue"

Vue.use(VueRouter);

const chatRoutes = [
  {
    path: "/web-socket-chat-page",
    name: "WebSocketChatPage",
    component: WebSocketChatPage,
  },
];

export default chatRoutes;