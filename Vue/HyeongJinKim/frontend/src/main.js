import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";

import GlobalComponent from "@/components/componentTest/GlobalComponent.vue";
import VueHomeworkGlobalComponent from "@/components/homework/problem1/GlobalComponent.vue";

Vue.config.productionTip = false;

Vue.component(GlobalComponent.name, GlobalComponent);
Vue.component(VueHomeworkGlobalComponent.name, VueHomeworkGlobalComponent);

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
