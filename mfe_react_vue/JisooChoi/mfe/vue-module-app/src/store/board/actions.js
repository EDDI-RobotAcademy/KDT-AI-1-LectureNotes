import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

import axiosInst from '../../utility/axiosInst'

export default {
    requestBoardToSpring ({ commit }, boardId) {
        return axiosInst.springAxiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    requestBoardListToSpring ({ commit }) {
        axiosInst.springAxiosInst.get('/jpa-board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    requestCreateBoardToSpring ({}, payload) {

        const { title, content, writer } = payload

        return axiosInst.springAxiosInst.post('/jpa-board/register', { title, content, writer })
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestDeleteBoardToSpring ({}, boardId) {
        return axiosInst.springAxiosInst.delete(`/jpa-board/${boardId}`)
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

        return axiosInst.springAxiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
            .then((res) => {
                alert("수정 성공!")
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}