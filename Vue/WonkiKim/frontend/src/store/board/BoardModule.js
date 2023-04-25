import Vue from "vue";
import Vuex from 'vuex';
import actions from "@/store/board/actions";
import states from "@/store/board/states";
import mutations from "@/store/board/mutations";

Vue.use(Vuex)

const boardModule = {
    namespced: true,
    states,
    actions,
    mutations,
}

export default BoardModule
