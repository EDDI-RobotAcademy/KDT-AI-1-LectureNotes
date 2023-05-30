import axiosInst from "@/utility/axiosInst";

export default {
  requestRegisterCharacterToSpring({}, payload) {
    const { name, number, imgPath } = payload;
    return axiosInst
      .post("/sanrio/register", { name, number, imgPath })
      .then((res) => {
        alert("등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
