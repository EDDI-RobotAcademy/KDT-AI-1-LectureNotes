import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/product/mutations"
import actions from "@/store/product/actions"
import state from "@/store/product/states"

Vue.use(Vuex)
//BoardModule을 사용하면 나머지 state,actions,mutation을 사용가능하도록 객채화 한것
const ProductModule = {
    namespaced: true,// 네임 스페이스 - 구별이 가능하다 없을경우 구별 어려움
    state,
    actions,
    mutations,
}

export default ProductModule