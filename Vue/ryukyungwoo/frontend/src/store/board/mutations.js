import {
    REQUEST_BOARD_LIST_TO_SPRING,
    
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) { // state와 spring에서 받은 receivedData로
        state.boards = receivedData // state.boards에 receivedData를 넣어줌
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {// state와 spring에서 받은 receivedData로
        state.board = receivedData// state.board에 receivedData를 넣어줌
    },
}