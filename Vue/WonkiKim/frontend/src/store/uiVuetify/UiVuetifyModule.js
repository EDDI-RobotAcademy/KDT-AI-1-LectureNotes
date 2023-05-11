import Vue from "vue";
import Vuex from "vuex";
import actions from "@/store/uiVuetify/actions";
import mutations from "@/store/uiVuetify/mutations";
import state from "@/store/uiVuetify/states";

Vue.use(Vuex)

const UiVuetifyModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default UiVuetifyModule