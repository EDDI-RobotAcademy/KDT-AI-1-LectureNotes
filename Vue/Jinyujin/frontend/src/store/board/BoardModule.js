import Vue from 'vue'
import Vuex from 'vuex'

import mutations from '@/store/board/mutations'
import actions from '@/store/board/actions'
import state from '@/store/board/states'

Vue.use(Vuex)

const BoardModule = {
    namespace: true,
    // 이게 활성화돼서 이제 보드모듈을 찾을 수 있게됨
    state,
    actions,
    mutations,
}

export default BoardModule
