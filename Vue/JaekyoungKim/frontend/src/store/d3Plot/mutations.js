import {
    REQUEST_TEST_HEALTH_DATA_TO_SPRING,
} from '@/store/d3Plot/mutation-types'

export default {
    [REQUEST_TEST_HEALTH_DATA_TO_SPRING] (state, receivedData) {
        state.healthDataList = receivedData
    },
}