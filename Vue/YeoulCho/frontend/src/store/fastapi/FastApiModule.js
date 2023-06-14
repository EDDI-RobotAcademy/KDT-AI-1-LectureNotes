import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/fastapi/actions"

Vue.use(Vuex)


const fastApiModule = {
    namespaced: true, 
    actions, 
}
    
export default fastApiModule