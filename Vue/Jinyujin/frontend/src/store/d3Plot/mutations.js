import {
    REQUEST_HEALTH_DATA_TO_SPRING,
    // REQUEST_HEALTH_AMOUNT_TO_SPRING,
    // REQUEST_HEALTH_DATE_TO_SPRING
} from '@/store/d3Plot/mutation-types'

export default {
    [REQUEST_HEALTH_DATA_TO_SPRING](state, receivedData) {
        state.data = receivedData
    },
    // [REQUEST_HEALTH_AMOUNT_TO_SPRING](state, receivedData) {
    //     state.healthAmount = receivedData
    // },
    // [REQUEST_HEALTH_DATE_TO_SPRING](state, receivedData) {
    //     state.date = receivedData
    // },
}