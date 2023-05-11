import {REQUEST_TEST_IMAGE_PATH_TO_SPRING} from "@/store/uiVuetify/mutation-types";

export default {
    [REQUEST_TEST_IMAGE_PATH_TO_SPRING] (state, receivedData) {
        state.imagePath = receivedData
    }
}