// 스프링에 데이터를 요청하는 동작 작성

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
    requestBoardListToSpring ({ commit }) {
        // mutations에 만들어져 있는 것은 commit에 의해 동작
        return axiosInst.get('/jpa-board/list')
        // 데이터를 스프링에 요청
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
                // 스프링에서 받은 데이터를 res에 저장한 후 
                // commit -> mutations에 등록한 사항이 동작하도록
            })
    },
    requestCreateBoardToSpring ({}, payload) {
        const { title, content, writer } = payload
        return axiosInst.post('/jpa-board/register', { title, content, writer })
        // post형식으로 title, content, writer를 스프링에 전송
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
                // res를 반환해주는 이유
                // 등록 onSubmit으로
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
    // modifyPage의 methods에 RequestBoardModifyToSpring을 맵핑해주었으니 생성
    requestBoardModifyToSpring ({}, payload) {
        const { title, content, writer, boardId } = payload

        console.log("title: " + title + ", content: " + content + 
                    ", writer: " + writer + ", boardId: " + boardId)

        return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
            .then((res) => {
                alert('수정 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}