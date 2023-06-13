import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING,
} from './mutation-types'

export default {
    //receivedData를 boards에 저장
    [REQUEST_PRODUCT_LIST_TO_SPRING](state, receivedData) {
        state.products = receivedData
    },
    //receivedData를 board에 저장
    [REQUEST_PRODUCT_TO_SPRING](state, receivedData) {
        state.product = receivedData
    },
}