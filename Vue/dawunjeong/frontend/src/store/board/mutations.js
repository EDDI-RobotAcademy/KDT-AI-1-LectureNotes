import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    // state에 있는 boards 데이터를 receivedDate로 변경합니다.
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData
    },
    // state에 있는 board 데이터를 receivedDate로 변경합니다.
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    },
}