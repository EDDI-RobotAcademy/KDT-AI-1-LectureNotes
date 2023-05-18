import axiosInst from "@/utility/axiosInst";
import {
  REQUEST_PRODUCT_LIST_TO_SPRING,
  REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";

export default {
  requestProductListToSpring({ commit }) {
    return axiosInst.get("/exam/get-products").then((res) => {
      commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data);
      console.log(res.data);
    });
  },
  requestProductToSpring({ commit }, productId) {
    return axiosInst.get(`exam/${productId}`).then((res) => {
      commit(REQUEST_PRODUCT_TO_SPRING, res.data);
    });
  },
  requestCreateProductToSpring({}, payload) {
    return axiosInst
      .post("exam/register-product", payload)
      .then(() => {
        alert("등록 성공");
      })
      .catch(() => {
        alert("등록 실패");
      });
  },
};
