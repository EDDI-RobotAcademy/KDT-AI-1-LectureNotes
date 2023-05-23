import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_PRODUCT_LIST_TO_SPRING] (state, receivedData) {
        state.products = receivedData
        //receivedData를 스테이트의 boards에 넣어라
    },
    [REQUEST_PRODUCT_TO_SPRING] (state, receivedData) {
        state.product = receivedData
        //받아온 데이터를  state.board에 넣어라
    },
}