import Vue from "vue";
import Vuex from 'vuex';

import actions from "@/store/basic/actions"

Vue.use(Vuex)

const BasicModule = {
    namespaced: true,
    actions,
}

export default BasicModule