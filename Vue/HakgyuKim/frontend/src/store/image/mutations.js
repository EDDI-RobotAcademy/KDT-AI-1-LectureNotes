import { REQUEST_IMAGE_NAME_TO_SPRING } from "./mutation-types";

export default {
  [REQUEST_IMAGE_NAME_TO_SPRING](state, receivedData) {
    state.imageName = receivedData;
  },
};
