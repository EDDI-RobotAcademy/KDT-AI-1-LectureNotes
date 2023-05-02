import Vue from 'vue'
import Vuex from 'vuex'

import mutations from '@/store/board/mutations'
import actions from '@/store/board/actions'
import state from '@/store/board/states'

Vue.use(Vuex)

const BoardModule = {
    // BoardModule을 통해 도메인 단위로 필요한 것들만 따로 관리해줄 수 있다
    namespaced: true,
    // namespaced가 활성화돼서 이제 원하는 페이지에서 BoardModule을 찾을 수 있게됨
    // Module이 여러개인 경우 사용하려는 Vue 페이지에서 사용할 수 있도록 해줌
    state,
    actions,
    mutations,
}

export default BoardModule
