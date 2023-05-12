import {
    REQUEST_EXERCISE_LIST_TO_SPRING,
} from './mutation-types'

export default {
    [REQUEST_EXERCISE_LIST_TO_SPRING] (state, receivedData) {
        state.exerciseList = receivedData
    }
}