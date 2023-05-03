import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    //receivedData를 boards에 저장
    [REQUEST_BOARD_LIST_TO_SPRING](state, receivedData) {
        state.boards = receivedData
    },
    //receivedData를 board에 저장
    [REQUEST_BOARD_TO_SPRING](state, receivedData) {
        state.board = receivedData
    },
}