import axiosInst from "@/utility/axiosInst";

export default {
    requestIntegerToFastApiAfterSpring({},) {
        return axiosInst
          .get("/fastapi-test/fastapi-integer-request")
          .then((res) => {
            return res.data;
          })
      },
}