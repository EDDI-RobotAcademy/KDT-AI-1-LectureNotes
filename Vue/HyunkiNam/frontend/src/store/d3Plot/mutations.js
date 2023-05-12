import {
    REQUEST_MOMENTUM_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_MOMENTUM_TO_SPRING](state, receivedData) {
        state.momentumList = receivedData
    },
}