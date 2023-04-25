import{
    REQUEST_BOARD_LIST_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestBoardListToSpring({ commit }) {
        return axiosInst.get('/jpa-board/list')
        .then((res) => {
            commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
        })
    }
} 
// axios적용을 여기서 하는것
// 유연한 대처가 가능