import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData
        //receivedData를 스테이트의 boards에 넣어라
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
        //받아온 데이터를  state.board에 넣어라
    },
}