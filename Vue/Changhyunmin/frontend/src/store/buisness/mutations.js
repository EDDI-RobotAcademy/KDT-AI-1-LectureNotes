import {
    REQUEST_BUISNESS_LIST_TO_SPRING,
    REQUEST_BUISNESS_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_BUISNESS_LIST_TO_SPRING] (state, receivedData) {
        state.buisness = receivedData
    },
    [REQUEST_BUISNESS_TO_SPRING] (state, receivedData) {
        state.buisness = receivedData
    },
}