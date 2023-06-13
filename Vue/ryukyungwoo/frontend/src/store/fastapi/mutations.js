import {
    REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING,
    REQUEST_INTEGER_TO_FASTAPI,
} from './mutation-types'

export default {
    [REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING] (state, receivedData) {
        state.receivedSpringFromFastApiInteger = receivedData
    },
    [REQUEST_INTEGER_TO_FASTAPI] (state, receivedData) {
        state.receivedFastApiInteger = receivedData
    },
}