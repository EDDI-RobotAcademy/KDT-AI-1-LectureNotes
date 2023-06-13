import {
    REQUEST_HEALTH_DATA_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_HEALTH_DATA_TO_SPRING] (state, receivedData) {
        state.healthDataList = receivedData
    },
}