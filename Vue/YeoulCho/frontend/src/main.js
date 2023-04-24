import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

//등록하고자 하는 전역 컴포넌트
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
import AddGlobalComponent from '@/components/componentTest/AddGlobalComponent.vue'

//과제- 전역 컴포넌트
import GlobalAddComponent from "@/components/homework/problem1/GlobalAddComponent.vue"

Vue.config.productionTip = false

//Vue 객체 전체에 GlobalComponent를 등록하는 과정
//Vue.componenr(이름, 컴포넌트) 형태라 보면 됨
Vue.component(GlobalComponent.name, GlobalComponent)
Vue.component(AddGlobalComponent.name, AddGlobalComponent)

Vue.component(GlobalAddComponent.name, GlobalAddComponent)


new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
