import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import productModule from '@/store/product/ProductModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import d3PlotModule from './d3Plot/D3PlotModule'
import filesModule from './files/FilesModule'
import foodModule from './food/FoodModule'
import fastApiModule from './fastapi/FastApiModule'
import springModule from './spring/FastApiModule'
import accountModule from './account/AccountModule'
import authenticationModule from './authentication/AuthenticationModule'
import afterLoginModule from './afterLogin/AfterLoginModule'

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
    springModule: springModule,
    accountModule: accountModule,
    authenticationModule: authenticationModule,
    afterLoginModule: afterLoginModule
  },
})

export default store