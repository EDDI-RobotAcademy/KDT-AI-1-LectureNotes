import {
    REQUEST_BOARD_LIST_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData
    },
}