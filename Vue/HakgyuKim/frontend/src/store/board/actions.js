import {
  REQUEST_BOARD_LIST_TO_SPRING,
  REQUEST_BOARD_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  // 게시물의 고유값 아이디로 지정한 게시물 가져오기
  requestBoardToSpring({ commit }, boardId) {
    return axiosInst.get(`/jpa-board/${boardId}`).then((res) => {
      commit(REQUEST_BOARD_TO_SPRING, res.data);
    });
  },
  // 게시물 전체 리스트 가져오기
  requestBoardListToSpring({ commit }) {
    return axiosInst.get("/jpa-board/list").then((res) => {
      commit(REQUEST_BOARD_LIST_TO_SPRING, res.data);
    });
  },
  // 게시물 제작
  requestCreateBoardToSpring({}, payload) {
    // 제목, 저자, 내용 데이터
    const { title, writer, content } = payload;

    return axiosInst
      .post("/jpa-board/register", { title, writer, content })
      .then((res) => {
        alert("게시물 등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
  // 지정한 게시물 삭제 요청
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
  // 게시물 수정하기
  requestBoardModifyToSpring({}, payload) {
    // 수정한 데이터
    // boardId는 수정한 게시물 혼돈 일어나지 않기 위함
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

    return axiosInst
      .put(`/jpa-board/${boardId}`, { title, content, writer })
      .then((res) => {
        alert("수정 성공!");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
