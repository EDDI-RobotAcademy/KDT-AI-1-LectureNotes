import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from "@/views/account/SignUp.vue";
import LogIn from "@/views/account/LogIn.vue";

Vue.use(VueRouter)

const accountRouter = [
    {
        path:"/sign-up",
        name:"SignUp",
        component: SignUp
    },
    {
        path:"/log-in",
        name:"LogIn",
        component: LogIn
    },

]
export default accountRouter
