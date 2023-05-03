import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import vuetify from './plugins/vuetify'

// 등록하고자 하는 전역 컴포넌트
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
import GlobalAddComponent from '@/views/homeworks/globaComponent/GlobalAddComponent.vue'

Vue.config.productionTip = false


// Vue객체 전체에 GlobalComponent를 등록하는 과정
// Vue.component(이름, 컴포넌트) 형태라 보면 됨
Vue.component(GlobalComponent.name,GlobalComponent)
Vue.component(GlobalAddComponent.name,GlobalAddComponent)

new Vue({
  store,
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
