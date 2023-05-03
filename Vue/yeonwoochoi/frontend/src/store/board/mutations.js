import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

export default {
    // (state 상태, receivedData 수신한 데이터 = 전달 받은 정보)
    [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
        // 이것을 가지고 있으면 게시물 리스트를 보여준다.
        // receivedData 전달 받은 정보가 state.boards에 전달이 된다.
        state.boards = receivedData
    },
    [REQUEST_BOARD_TO_SPRING] (state, receivedData) {
        state.board = receivedData
    },
}