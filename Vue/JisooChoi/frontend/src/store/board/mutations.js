import {
  REQUEST_BOARD_LIST_TO_SPRING,
  REQUEST_BOARD_TO_SPRING,
} from "./mutation-types";

                                 // ↓이는 현재 store 객체의 states의 내용이 들어가 있다.
export default {                 // ↓      ↓actions에서 이는 전달된 정보 (payload) = 즉, 수신한 데이터를 말함
  [REQUEST_BOARD_LIST_TO_SPRING](state, receivedData) {
    state.boards = receivedData;
    // 그래서 이를 가지고 있으면 게시판 리스트를 쭉 볼 수 있다.
  },
  [REQUEST_BOARD_TO_SPRING](state, receivedData) {
    state.board = receivedData;
  },
};
