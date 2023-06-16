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
  getAccessTokenFromSpringRedirection({}, payload) {
    const { code } = payload;
    console.log("ready to request access token: " + JSON.stringify(payload));
    console.log("code: " + code);

    setTimeout(() => console.log("after"), 3000);
    axiosInstances.springAxiosInst
      .get(`/authentication/github/oauth-code?code=${code}`)
      .then((res) => {
        alert("res: " + JSON.stringify(res.data));
        router.push("/");
      })
      .catch((res) => {
        alert("문제 발생!");
      });
  },
};
