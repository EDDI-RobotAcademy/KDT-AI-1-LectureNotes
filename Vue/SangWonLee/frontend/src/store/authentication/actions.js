import {} from "./mutation-types";

import axiosInstances from "@/utility/axiosInst";

export default {
  requestGithubLoginToSpring({}) {
    return axiosInstances.springAxiosInst
      .get("/authentication/github/login")
      .then((res) => {
        console.log("result: " + res.data);
        return res.data;
      })
      .catch((res) => {
        alert("문제 발생!");
      });
  },
  getAccessTokenFromSpringRedirection(payload) {
    const { code } = payload;
    axiosInstances
      .springAxiosInst(`/authentication/github/oauth-code?code=${code}`)
      .then((res) => {
        alert("res: " + JSON.stringify(res.data));
        router.push("/");
      })
      .catch((res) => {
        alert("문제 발생!");
      });
  },
};
