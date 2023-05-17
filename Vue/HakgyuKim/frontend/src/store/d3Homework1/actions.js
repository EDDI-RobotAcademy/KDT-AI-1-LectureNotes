import axiosInst from "@/utility/axiosInst";
import {
    REQUEST_EXERCISE_LIST_TO_SPRING,
} from "./mutation-types";

export default {
    requestExerciseListToSpring({ commit }) {
        return axiosInst.get("/d3-problem/getGraphInfo").then((res) => {
            commit(REQUEST_EXERCISE_LIST_TO_SPRING, res.data)
        })
    }
}