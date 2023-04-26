import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData
        //받은 데이터를 state.boards에 할당한다.
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    },
}