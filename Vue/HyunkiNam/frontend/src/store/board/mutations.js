import {
    REQUEST_BOARD_LIST_TO_SRPING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SRPING](state, receivedData) {
        state.boards = receivedData
    }
}