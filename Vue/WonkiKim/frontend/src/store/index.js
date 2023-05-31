import Vue from 'vue'
import Vuex from 'vuex'

import boardModule from '@/store/board/BoardModule.js'
import uiVuetifyModule from  '@/store/uiVuetify/UiVuetifyModule'
import filesModule from "@/store/files/FileModule";
import foodModule from "@/store/food/FoodModule";
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    uiVuetifyModule: uiVuetifyModule,
    filesModule: filesModule,
    foodModule: foodModule,

  },
})

export default store