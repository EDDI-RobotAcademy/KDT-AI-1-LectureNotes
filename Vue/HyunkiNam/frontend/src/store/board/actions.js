import {
    REQUEST_BOARD_LIST_TO_SRPING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestBoardListToSpring({ comimit }) {
        return axiosInst.get('jpa-board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SRPING, res.data)
            })
    }
}