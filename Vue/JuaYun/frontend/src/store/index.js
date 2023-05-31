import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import uiVuetifyModule from '@/store/uiVuetify/UiVuetifyModule.js'
import d3PlotModule from '@/store/d3Plot/D3PlotModule.js'
import filesModule from '@/store/files/FilesModule.js'
import foodModule from './food/FoodModule'
import fastApiModule from './fastapi/FastApiModule'
import accountModule from './account/AccountModule'
import authenticationModule from './authentication/AuthenticationModule'
import afterLoginModule from './afterLogin/AuthenticationModule'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    d3PlotModule: d3PlotModule,
    filesModule: filesModule,
    foodModule: foodModule,
    fastApiModule: fastApiModule,
    accountModule: accountModule,
    authenticationModule: authenticationModule,
    afterLoginModule: afterLoginModule
  },
})

export default store