import {
    REQUEST_HEALTH_PROB_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_HEALTH_PROB_TO_SPRING] (state, requestData) {
        state.healthList = requestData
    }
}