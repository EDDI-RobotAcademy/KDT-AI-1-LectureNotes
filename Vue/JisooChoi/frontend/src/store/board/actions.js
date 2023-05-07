import {
  REQUEST_BOARD_LIST_TO_SPRING,
  REQUEST_BOARD_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  /*
    기본적으로 Vuex는 action에서 commit을 한 값을
    mutation에 대입해주어 state를 변화시킨다.
    
    component -> action -> mutation -> state

    즉, API를 이용해 받은 response 값을 commit으로 저장하여
    getter를 호출해 가져오는 "형태"로 사용한다.

    그래서 commit은 state에 값을 넣는 작업이다.
  */
  requestBoardToSpring({ commit }, boardId) {
    return axiosInst.get(`/jpa-board/${boardId}`).then((res) => {
      commit(REQUEST_BOARD_TO_SPRING, res.data);
    });
  },
  /*
    실제 action은 외부에서 가져오고 현재 값을 유지하겠다는 것이 commit이며,
    default 값이 commit이다.

    또한 action은 비동기 처리를 하나 commit은 동기(=순차적) 처리를 한다.
  */
  requestBoardListToSpring({ commit }) {
    return axiosInst.get("/jpa-board/list").then((res) => {
      commit(REQUEST_BOARD_LIST_TO_SPRING, res.data);
    });
  },
  requestCreateBoardToSpring({}, payload) {
    // payload 로 전달된 값은 불변 객체로 만들어 준 것들이 전달된다.
    const { title, content, writer } = payload;

    return axiosInst
      .post("/jpa-board/register", { title, content, writer })
      .then((res) => {
        alert("게시물 등록 성공!");
        // title, content, writer가 든 (게시물)엔터티를 리턴 값으로 받아왔다.
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
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
  requestBoardModifyToSpring({}, payload) {
    const { title, content, boardId, writer } = payload;

    console.log("title: " +title +", content: " +content +
                ", writer: " +writer +", boardId: " +boardId);

    return axiosInst
    // 가변 인자 처리는 벡틱 (`) 사용
                                                    // ↓writer는 전달 안해줘도 되나, 백엔드 폼에 이미 구성되어 있기 때문에 같이 넣어주었다. 
      .put(`/jpa-board/${boardId}`, { title, content, writer })
      .then((res) => {
        alert("수정 성공!");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
