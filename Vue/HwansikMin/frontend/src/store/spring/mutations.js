import {
    REQUEST_INTEGER_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_INTEGER_TO_SPRING] (state, receivedData) {
        state.receivedSpringInteger = receivedData
    },
}