import { REQUEST_IMAGE_NAME_TO_SPRING } from "./mutation-types";
import axiosInst from "@/utility/axiosInst";

export default {
  requestImageNameToSpring({ commit }, payload) {
    const { imageName } = payload;
    console.log(imageName);
    return axiosInst
      .post("/image-problem/getImageName", { imageName })
      .then((res) => {
        commit(REQUEST_IMAGE_NAME_TO_SPRING, res.data);
        return res.data;
      });
  },
};
