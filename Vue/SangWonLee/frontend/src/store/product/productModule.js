import Vue from "vue";
import Vuex from "vuex";

import mutations from "@/store/product/mutations";
import actions from "@/store/product/actions";
import state from "@/store/product/states";

Vue.use(Vuex);

// 모듈을 사용하여 스토어의 여러개의 작은 모듈로 분리하여
// 관리할 수 있어 코드의 구조화와 유지 보수가 용이해진다.

const productModule = {
  namespaced: true,
  // 모듈의 mutations, actions, states 등은 모듈의 접두사로 사옹하여
  // 다른 모듈과 구분된다. 그러므로, 다른 모듈과 이름이 겹쳐서 충돌이
  // 일어나지 않게 한다.
  state,
  actions,
  mutations,
};

export default productModule;
// 전역 변수로 설정하는 productModule 생성
