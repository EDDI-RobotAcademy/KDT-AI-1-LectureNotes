import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING
} from './mutation-types'

// actions에 있는 매서드로 받아온 데이터를 state에 저장하기 위함
export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    }
}