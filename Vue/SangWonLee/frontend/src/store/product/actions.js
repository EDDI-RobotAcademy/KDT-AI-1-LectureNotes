import {
  REQUEST_PRODUCT_LIST_TO_SPRING,
  REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  requestCreateProductToSpring({}, payload) {
    const { name, price, company, manufactureDate, category } = payload;

    return axiosInst
      .post("/product/register", {
        name,
        price,
        company,
        manufactureDate,
        category,
      })
      .then((res) => {
        alert("상품 등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
