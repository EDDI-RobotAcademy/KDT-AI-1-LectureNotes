import Vue from 'vue'
import VueRouter from 'vue-router'

import AccessToken from "@/components/authentication/AccessToken.vue";

Vue.use(VueRouter)

const authenticationTestRoutes = [
    {
        path: '/github/getAccessToken',
        name: 'AccessToken',
        component: AccessToken
    },
]

export default authenticationTestRoutes