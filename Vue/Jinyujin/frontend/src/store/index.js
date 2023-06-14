import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import productModule from '@/store/product/ProductModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule'
import d3PlotModule from '@/store/d3Plot/D3PlotModule'
import filesModule from '@/store/files/FilesModule'
import foodModule from './food/FoodModule'
import fastApiModule from './fastapi/FastApiModule'
import vueSpringFastApiModule from './vueSpringFastApi/VueSpringFastApiModule'
import accountModule from './account/AccountModule'
import authenticationModule from './authentication/AuthenticationModule'
import afterLoginModule from './afterLogin/AfterLoginModule'
import kerasModule from './keras/KerasModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    productModule: productModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
    fastApiModule: fastApiModule,
    vueSpringFastApiModule: vueSpringFastApiModule,
    accountModule: accountModule,
    authenticationModule: authenticationModule,
    afterLoginModule: afterLoginModule,
    kerasModule: kerasModule,
  },
})

export default store
