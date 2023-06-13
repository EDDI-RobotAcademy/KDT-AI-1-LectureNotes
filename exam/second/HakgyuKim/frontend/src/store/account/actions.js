import axiosInst from "@/utility/axiosInst";

export default {
  requestSignupToSpring({}, payload) {
    const { email, password, role, businessNumber } = payload;
    return axiosInst
      .post("/exam/make-account", { email, password, role, businessNumber })
      .then((res) => {
        if (res.data) {
          alert("가입 성공!");
        } else {
          alert("동일한 계정이 이미 존재합니다");
        }
      });
  },
  requestLoginToSpring({}, payload) {
    const { email, password } = payload;
    return axiosInst
      .post("/exam/login", { email, password })
      .then((res) => {
        alert("로그인 성공");
        let accountId = res.data.accountId;
        localStorage.setItem("loginUserInfo", accountId);
      })
      .catch(() => {
        alert("로그인 실패");
      });
  },
  requestCheckRoleToSpring({}, accountId) {
    console.log(accountId);
    return axiosInst.post("/exam/check-role", { accountId }).then((res) => {
      return res.data;
    });
  },
};
