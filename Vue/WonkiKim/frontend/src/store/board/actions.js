import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    //actions는 비동기 함수들을 처리한다.
    requestBoardToSpring ({ commit }, boardId) {
        //원래는 context를 받지만 commit만 사용할 것이므로 코드를 단순화 하기위해 commit만 받고(destructuring) 페이로드로 boardId를 받는다.
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
        //정의된 axios인스턴스로 페이로드를 보내고 respons가 도착하면 REQUEST_BOARD_TO_SPRING에 res.data를 커밋한다.
    },
    requestBoardListToSpring ({ commit }) {
        return axiosInst.get('/jpa-board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
        //BoardList를 받아올 때는 페이로드가 없다.
    },
    requestCreateBoardToSpring ({}, payload) {

        const { title, content, writer } = payload
        //Board를 만들땐 {title, content, writer}객체를 페이로드로 보낸다.
        return axiosInst.post('/jpa-board/register', { title, content, writer })
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
}