import axiosInst from "@/utility/axiosInst";

export default {
    requestSignUp({}, payload) {
        return axiosInst.post("/account/sign-up", payload)
            .then((res) => {
                return res
            })
            .catch(alert("실패"))
    },
    requestLogIn({}, payload) {
        return axiosInst.post("/account/log-in", payload)
            .then((res) => {
                alert("로그인 성공 id: " + res.data)
                return res
            })
    }
}