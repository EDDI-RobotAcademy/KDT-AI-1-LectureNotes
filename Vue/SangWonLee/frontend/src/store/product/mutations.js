import {
  REQUEST_PRODUCT_LIST_TO_SPRING,
  REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";
// mutation-types에서 REQUEST_PRODUCT_LIST_TO_SPRING, REQUEST_PRODUCT_TO_SPRING 두 개의 상수를 가져와서 사용한다.


export default {
  [REQUEST_PRODUCT_LIST_TO_SPRING](state, receivedData) {
    state.products = receivedData;
  }, // 메소드 이름이 REQUEST_PRODUCT_LIST_TO_SPRING으로 첫번째 매개변수는 state, 두번째 매개변수는 receivedData
  [REQUEST_PRODUCT_TO_SPRING](state, receivedData) {
    state.product = receivedData;
  }, // 메소드 이름이 REQUEST_PRODUCT_TO_SPRING으로 첫번째 매개변수는 state, 두번째 매개변수는 receivedData
};
