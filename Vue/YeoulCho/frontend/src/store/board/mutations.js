import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData //받아오기만함 출력안함
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    },
}