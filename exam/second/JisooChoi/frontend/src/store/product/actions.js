import {
    REQUEST_PRODUCT_LIST_TO_SPRING,
    REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";
  
import axiosInst from "@/utility/axiosInst";
  
export default {
    requestProductListToSpring({ commit }) {
        return axiosInst.get("/exam-test22/list")
        .then((res) => {
          commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data);
        });
      },
};