import {
    REQUEST_HEALTHDATA_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_HEALTHDATA_TO_SPRING] (state, receivedData) {
        state.healthDataList = receivedData
    },
}