import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/files/actions"

Vue.use(Vuex)
// 파일은 실질적으로 프로덕트 쪽에 도메인을 놔두는게 맞음
const FilesModule = {
    namespaced: true,
    actions,
}

export default FilesModule