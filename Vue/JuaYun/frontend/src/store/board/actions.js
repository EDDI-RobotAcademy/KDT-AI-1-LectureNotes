import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

// Page에서 처리된 정보가 여기를 거쳐 spring으로 가는 것으로 생각하고있음
// spring 에서 보낸 정보도 여기를 거쳐 뿌리는 것 같음

export default {
    // commit 은 디폴트 값
    // 동기처리라고 생각하면됨 연결될 때까지 기다리는 것
    // 단순하게 정보를 뿌리기만 하면 되는 것들은 get을 받는 것 같음
    requestBoardToSpring ({ commit }, boardId) {
        console.log(", boardId: " + boardId)

        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    requestBoardListToSpring  ({ commit }) {
        return axiosInst.get('/jpa-board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    requestCreateBoardToSpring ({}, payload) {
        const { title, content, writer } = payload

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
    },
} 
// axios적용을 여기서 하는것
// 유연한 대처가 가능