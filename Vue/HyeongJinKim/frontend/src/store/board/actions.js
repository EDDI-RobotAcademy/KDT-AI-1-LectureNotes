import { REQUEST_BOARD_LIST_TO_SPRING, REQUEST_BOARD_TO_SPRING } from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  requestBoardToSpring({ commit }, boardId) {
    return axiosInst.get(`/jpa-board/${boardId}`).then((res) => {
      commit(REQUEST_BOARD_TO_SPRING, res.data);
    });
  },
  // boardId값의 board를 return

  requestBoardListToSpring({ commit }) {
    return axiosInst.get("/jpa-board/list").then((res) => {
      commit(REQUEST_BOARD_LIST_TO_SPRING, res.data);
    });
  },
  // board가 든 List를 return

  requestCreateBoardToSpring({}, payload) {
    const { title, content, writer } = payload;
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

  requestDeleteBoardToSpring({}, boardId) {
    // Spring으로 boardId값 전달
    return (
      axiosInst
        .delete(`/jpa-board/${boardId}`)
        // boardId의 값에 따라 달라지는 가변인자
        .then((res) => {
          alert("삭제 성공!");
        })
        .catch(() => {
          alert("문제 발생!");
        })
    );
  },
  requestBoardModifyToSpring({}, payload) {
    const { title, content, boardId, writer } = payload;

    console.log(
      "title: " +
        title +
        ", content: " +
        content +
        ", writer: " +
        writer +
        ", boardId: " +
        boardId
    );

    return (
      axiosInst
        .put(`/jpa-board/${boardId}`, { title, content, writer })
        // backend의 modifyBoard로 값 전달, 주소는 가변인자로
        // 받아온 title, content, writer값은 RequestBody로 받고
        // boardId값은 PathVariable를 통해 Long boardId로.
        .then((res) => {
          alert("수정 성공!");
        })
        .catch(() => {
          alert("문제 발생!");
        })
    );
  },
};
