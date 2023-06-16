import Vue from "vue";
import VueRouter from "vue-router";

import SignUpPage from "@/views/account/SignUpPage.vue";
import SignInPage from "@/views/account/SignInPage.vue";

Vue.use(VueRouter);

const accountTestRoutes = [
  {
    path: "/sign-up-page",
    name: "SignUpPage",
    component: SignUpPage,
  },
  {
    path: "/sign-in-page",
    name: "SignInPage",
    component: SignInPage,
  },
];

export default accountTestRoutes;
