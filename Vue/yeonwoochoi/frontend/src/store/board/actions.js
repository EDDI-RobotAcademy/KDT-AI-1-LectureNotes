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
    // 외부(BoardListPage)에서 값을 가져오고, commit 으로 값을 유지한다.
    // axiosInst 비동기 처리 하고, commit은 동기 처리 한다.
    // 둘의 차이점 :
    // 동기 - 순서가 있음 (통신 개념으로 전화를 받아야만 받아진다.)
    // 비동기 - 순서가 지켜지지 않음 (카톡 개념으로 읽지 않아도 받아진다.)
    requestBoardListToSpring ({ commit }) {
        // axiosInst.get : backend에서 전달 받는다.
        // get 요청을 보낸다. 
        return axiosInst.get('/jpa-board/list') 
        // axiosInst의 결과는 .then((res) 전달이 된다.
        // res 값 가져옴 
            .then((res) => {
                // backend에서 받아온 값(res.data)
                // REQUEST_BOARD_LIST_TO_SPRING(mutations으로 전달)
                // res.data 문법이라 res뒤에 .data를 붙여준다.
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    // actions에서 사용하는 매서드는 commit이고, {}의 의미는 
    // 실제로 mutations 작업을 수행하지 않을것이라서 commit을 사용할 필요가 
    // 없으니 비워두기 위해서 ‘{}’ 를 표현 한다. (일종의 명시성 - 안쓴다는 명시)
    requestCreateBoardToSpring ({}, payload) {
        // title, content, writer는 payload 여기에 저장이 된다.
        const { title, content, writer } = payload
        // PostMapping : { title, content, writer }를 backend로 전달 한다.
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

    // 가변인자 사용할때 `/jpa-board/${boardId}`  ``를 사용한다.
    // 가변 인자 매개변수 = 개수가 변하는 인자들을 넘길 수 있는 매개변수이다.
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