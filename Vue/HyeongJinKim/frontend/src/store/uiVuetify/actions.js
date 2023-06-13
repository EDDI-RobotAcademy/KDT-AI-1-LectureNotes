import { REQUEST_TEST_IMAGE_PATH_TO_SPRING } from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  requestImagePathToSpring({ commit }) {
    return axiosInst.get("/give-me/image-path").then((res) => {
      commit(REQUEST_TEST_IMAGE_PATH_TO_SPRING, res.data);
      return res.data;
    });
  },
};
