import {
    REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING,
} from './mutation-types'

export default {
    [REQUEST_INTEGER_TO_FASTAPI_AFTER_SPRING] (state, receivedData) {
        state.receivedInteger = receivedData
    },
}