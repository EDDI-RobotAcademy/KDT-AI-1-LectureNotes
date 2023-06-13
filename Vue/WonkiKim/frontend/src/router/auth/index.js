import VueRouter from "vue-router";
import Vue from "vue";
import SignUpPage from "@/views/auth/signUpPage.vue";

Vue.use(VueRouter)
const authRoutes = [
  {
    path: "/sign-up-page",
    name: "SignUpPage",
    component: SignUpPage
  }
]

export default authRoutes