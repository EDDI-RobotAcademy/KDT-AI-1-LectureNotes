import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'
//mutaion-types에서 선언한 변수 가져오겠다.

export default {
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        state.boards = receivedData //받아오기만함 출력안함
        //(state, receivedData)를 받아서 state.boards에 receivedData를 할당하겠다.
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    },
}