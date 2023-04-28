import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'

import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
import PlusComponent from '@/components/homeworkComponent/problem1/PlusComponent.vue'

Vue.config.productionTip = false

Vue.component(GlobalComponent.name, GlobalComponent)
Vue.component(PlusComponent.name, PlusComponent)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
