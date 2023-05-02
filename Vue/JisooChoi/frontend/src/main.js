import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";

// 등록하고자 하는 전역 컴포넌트
import GlobalComponent from "@/components/componentTest/GlobalComponent.vue";

// 숙제 -  1. 덧셈 전역 컴포넌트
import HomeworkGlobalComponent from "@/components/homework/problem1/HomeworkGlobalComponent.vue";

Vue.config.productionTip = false;

// Vue 객체 전체에 GlobalComponent를 등록하는 과정
// Vue.component(이름, 컴포넌트) 형태라 보면 된다.
Vue.component(
  GlobalComponent.name,
  GlobalComponent
); /* 어디서든 사용할 수 있게 된다. */

Vue.component(
  HomeworkGlobalComponent.name,
  HomeworkGlobalComponent
); /* 어디서든 사용할 수 있게 된다. */

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
