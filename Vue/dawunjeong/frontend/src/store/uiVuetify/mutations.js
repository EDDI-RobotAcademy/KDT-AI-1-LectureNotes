import {
    REQUEST_TEST_IMAGE_PATH_TO_SPRING,
    REQUEST_TEST_IMAGE_NAME_TO_SPRING
} from './mutation-types'

export default {
    [REQUEST_TEST_IMAGE_PATH_TO_SPRING] (state, receivedData) {
        state.imagePath = receivedData
    },
    [REQUEST_TEST_IMAGE_NAME_TO_SPRING] (state, receivedData) {
        state.imageName = receivedData
    },
}