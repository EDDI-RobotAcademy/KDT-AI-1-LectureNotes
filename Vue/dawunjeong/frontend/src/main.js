import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

// 동록하고자 하는 전역 컴포넌트
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
import GlobalComponentAdd from '@/components/componentTest/homework/GlobalComponentAdd.vue'
import GlobalAddComponent from '@/components/homeworkSolve/problem1/GlobalAddComponent.vue'

Vue.config.productionTip = false

// Vue 객체 전체에 GlobalComponent를 등록하는 과정
// Vue.component(이름, 컴포넌트) 형태라 보면 됨
Vue.component(GlobalComponent.name, GlobalComponent)
Vue.component(GlobalComponentAdd.name, GlobalComponentAdd)

// 선생님 과제 풀이
Vue.component(GlobalAddComponent.name, GlobalAddComponent)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')