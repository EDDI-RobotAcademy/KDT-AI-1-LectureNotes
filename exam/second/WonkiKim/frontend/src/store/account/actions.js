import axiosInst from "@/utility/axiosInst";

export default {
    requestSignUp({}, payload) {
        return axiosInst.post("/account/sign-up", payload)
            .then((res) => alert("id: " + res.data))
            .catch(alert)
    }
}