import {
  REQUEST_BOARD_LIST_TO_SPRING,
  REQUEST_BOARD_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  // 기본적으로 Vuex를 사용하면 mutation을 이용한 action.js에서 commit을 한다.
  // 즉, API를 이용해 받은 response 값을 commit으로 저장하여 getter를 호출해 가져오는 형태로 사용한다.
  requestBoardToSpring({ commit }, boardId) {
    return axiosInst.get(`/jpa-board/${boardId}`)
    .then((res) => {
      commit(REQUEST_BOARD_TO_SPRING, res.data);
      // ※ commit은 state에 값을 넣는 작업
    });
  },
  requestBoardListToSpring({ commit }) { // default 값이 commit이다.
    // ※ commit은 로테이션 타입, k로드 타입, ... 등 (질문방 확인)
    // 실제 액션은 외부에서 가져오고 현재 값을 유지하겠다는 것이 commit이다.
    // action은 비동기 처리를 하나
    return axiosInst.get("/jpa-board/list")
    .then((res) => {
      commit(REQUEST_BOARD_LIST_TO_SPRING, res.data);
      // commit은 동기 처리를 한다.
    });
  },
  requestCreateBoardToSpring({}, payload) {
    // payload 로 전달된 값은 불변 객체로 만들어 준 것들이 전달된다.
    const { title, content, writer } = payload;

    // 게시물 등록
    return axiosInst.post("/jpa-board/register", { title, content, writer })
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
    return axiosInst.delete(`/jpa-board/${boardId}`)
      .then((res) => {
        alert("삭제 성공!");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
  requestBoardModifyToSpring ({}, payload) {
    const { title, content, boardId, writer } = payload

    console.log("title: " + title + ", content: " + content + 
                ", writer: " + writer + ", boardId: " + boardId)

    return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
        .then((res) => {
            alert("수정 성공!")
        })
        .catch(() => {
            alert('문제 발생!')
        })
      }
};
