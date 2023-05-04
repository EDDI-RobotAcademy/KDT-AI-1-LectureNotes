import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestBoardListToSpring({ commit }) {
        return axiosInst.get('/jpa-board/list')
            .then((res) => {
                // REQUEST_BOARD_LIST_TO_SPRING를 통해서 res.data를 boards에 저장
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    requestCreateBoardToSpring({ }, payload) {

        const { title, content, writer } = payload

        // Spring에 POST형식으로 title, content, writer 값을 RequestBody로 전송
        return axiosInst.post('/jpa-board/register', { title, content, writer })
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestBoardToSpring({ commit }, boardId) {
        // Spring에 GET형식으로 boardId를 URL 변수로 전송?
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                // REQUEST_BOARD_TO_SPRING 통해서 res.data를 board에 저장
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    requestDeleteBoardToSpring({ }, boardId) {
        // Spring에 DELETE형식으로 boardId를 URL 변수로 전송? (삭제 요청)
        return axiosInst.delete(`/jpa-board/${boardId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestBoardModifyToSpring({ }, payload) {
        const { title, content, boardId, writer } = payload

        console.log("title: " + title + ", content: " + content +
            ", writer: " + writer + ", boardId: " + boardId)
        // Spring에 PUT형식으로 boardId를 URL 변수로,
        // title, content, writer 값을 RequestBody로 전송 (업데이트 요청)
        return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
            .then((res) => {
                alert("수정 성공!")
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}