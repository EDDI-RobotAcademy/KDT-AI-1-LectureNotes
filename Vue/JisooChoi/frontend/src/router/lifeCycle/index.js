import Vue from "vue";
import VueRouter from "vue-router";

import VueLifeCycleTestPage from "@/views/lifeCycle/VueLifeCycleTestPage.vue";

Vue.use(VueRouter);

const lifeCycleRoutes = [
    {
        path: "/vue-lifecycle-test",
        name: "VueLifeCycleTestPage",
        component: VueLifeCycleTestPage,
        },
];

export default lifeCycleRoutes;
