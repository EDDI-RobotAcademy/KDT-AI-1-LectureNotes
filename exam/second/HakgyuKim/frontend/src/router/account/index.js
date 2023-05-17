import Vue from "vue";
import VueRouter from "vue-router";

import SignupPage from "@/views/account/SignupPage.vue";
import LoginPage from "@/views/account/LoginPage.vue";

Vue.use(VueRouter);

const accountRoutes = [
  {
    path: "/signup-page",
    name: "SignupPage",
    component: SignupPage,
  },
  {
    path: "/login-page",
    name: "LoginPage",
    component: LoginPage,
  },
];

export default accountRoutes;
