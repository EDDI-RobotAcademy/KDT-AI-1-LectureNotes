import axiosInst from "@/utility/axiosInst";

export default {
    requestCreateFoodToSpring({}, payload) {
        return axiosInst.post("/food-test/register", payload)
            .then(() => {
                alert
            })
            .catch(() => {
                alert("문제발생")
            })
    }
}