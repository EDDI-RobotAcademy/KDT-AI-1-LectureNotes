import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_PRODUCT_LIST_TO_SPRING] (state, receivedData) {
        state.products = receivedData
    }
}