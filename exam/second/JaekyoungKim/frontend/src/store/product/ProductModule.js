import Vue from 'vue'
import Vuex from 'vuex'


import actions from "@/store/product/actions"


Vue.use(Vuex)
//BoardModule을 사용하면 나머지 state,actions,mutation을 사용가능하도록 객채화 한것
const ProductModule = {
    namespaced: true,// 네임 스페이스 - 구별이 가능하다 없을경우 구별 어려움

    actions,

}

export default ProductModule