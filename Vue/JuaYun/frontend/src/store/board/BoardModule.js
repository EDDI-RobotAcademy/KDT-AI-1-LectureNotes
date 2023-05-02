import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

// store의 사용의도는 도메인이라고 생각하면 된다.
// 도메인 단위로 작업을 분할하기 위해 사용하는 기법
// 선생님은 BoardModule 이 도메인이라고 생각하면 된다고 말했음
// 내부의 정보를 관리하고 새로운 정보를 추가하면 
// 새로운 모듈을 만들어서 관리하면 된다.
// 여기에 설정하면 다른 파일에서는 boardModule 소문자로 생성가능
const BoardModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default BoardModule