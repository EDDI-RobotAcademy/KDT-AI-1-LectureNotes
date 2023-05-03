import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// vuetify 전역 컴포넌트
// v-container, v-app, v-btn, v-img 등등
// vuetify 전용 컴포넌트들을 아무런 import 없이 사용하고 있다.
import vuetify from './plugins/vuetify' 

// 등록하고자 하는 전역 컴포넌트
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'

Vue.config.productionTip = false

// Vue객체 전체에 GlobalComponent를 등록하는 과정
// Vue.component(이름, 컴포넌트) 형태라 보면 됨
Vue.component(GlobalComponent.name, GlobalComponent)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
