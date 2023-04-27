import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestBoardToSpring ({ commit }, boardId) {
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    // BoardListPage 외부에서 값을 가져오고, commit 으로 값을 유지한다.
    // axiosInst 비동기 처리 하고, commit은 동기 처리 한다.
    // 둘의 차이점 :
    // 동기 - 순서가 있음 (통신 개념으로 전화를 받아야만 받아진다.)
    // 비동기 - 순서가 지켜지지 않음 (카톡 개념으로 읽지 않아도 받아진다.)
    requestBoardListToSpring ({ commit }) {
        return axiosInst.get('/jpa-board/list')
        // axiosInst의 결과는 .then((res) 전달이 된다.
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    requestCreateBoardToSpring ({}, payload) {
        // payload 여기에 저장이 된다.
        const { title, content, writer } = payload
        // PostMapping 
        return axiosInst.post('/jpa-board/register', { title, content, writer })
            // axios에 대한 요청은 res(result) 결과라는 변수에 저장됩니다.
            // 그러므로 2번째 그림에서 res가 실제 axios 요청을 통해 확보한 결과값에 해당합니다.
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestDeleteBoardToSpring ({}, boardId) {
        return axiosInst.delete(`/jpa-board/${boardId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestBoardModifyToSpring ({}, payload) {
        const { title, content, boardId, writer } = payload

        // console 확인하는 코드
        console.log("title: " + title + ", content: " + content + 
                    ", writer: " + writer + ", boardId: " + boardId)

    // 가변인자
    // 실제 수정한  title, content를 전달
    // writer는 필요없지만 전달한 이유는 form이 정해져 있어서 작성함
    return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
        .then((res) => {
           alert("수정 성공!")
         })
         .catch(() => {
         alert('문제 발생!')
         })
    },
}