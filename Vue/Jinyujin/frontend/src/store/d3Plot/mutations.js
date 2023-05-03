import {
    REQUEST_HEALTH_DATA_TO_SPRING,
} from '@/store/d3Plot/mutation-types'

export default {
    [REQUEST_HEALTH_DATA_TO_SPRING](state, receivedData) {
        state.data = receivedData
    },
}