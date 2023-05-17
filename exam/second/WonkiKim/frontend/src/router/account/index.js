import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from "@/views/account/SignUp.vue";

Vue.use(VueRouter)

const accountRouter = [
    {
        path:"/sign-up",
        name:"SignUp",
        component: SignUp
    },

]
export default accountRouter
