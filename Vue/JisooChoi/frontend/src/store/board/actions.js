import {
  REQUEST_BOARD_LIST_TO_SPRING,
  REQUEST_BOARD_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  // 기본적으로 Vuex를 사용하면 mutation을 이용한 action.js에서 commit을 한다.
  // 즉, API를 이용해 받은 response 값을 commit으로 저장하여 getter를 호출해 가져오는 형태로 사용한다.
  requestBoardToSpring({ commit }, boardId) {
    return axiosInst.get(`/jpa-board/${boardId}`).then((res) => {
      commit(REQUEST_BOARD_TO_SPRING, res.data);
    });
  },
  requestBoardListToSpring({ commit }) {
    return axiosInst.get("/jpa-board/list").then((res) => {
      commit(REQUEST_BOARD_LIST_TO_SPRING, res.data);
    });
  },
  requestCreateBoardToSpring({}, payload) {
    const { title, content, writer } = payload;

    // 게시물 등록
    return axiosInst
      .post("/jpa-board/register", { title, content, writer })
      .then((res) => {
        alert("게시물 등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
  // 게시물 삭제
  requestDeleteBoardToSpring({}, boardId) {
    return axiosInst
      .delete(`/jpa-board/${boardId}`)
      .then((res) => {
        alert("삭제 성공!");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
