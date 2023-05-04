import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'
//mutation-types에서 임폴트 해옴

import axiosInst from '@/utility/axiosInst'
// baseURL: 'http://localhost:7777' 이기 때문에 따로 설정 안해줘도 됨

export default {
    requestBoardListToSpring ({ commit }) {
        return axiosInst.get('/jpa-board/list')
            .then((res) => {
                //get으로 받아온 res.data를  REQUEST_BOARD_LIST_TO_SPRING사용
                //REQUEST_BOARD_LIST_TO_SPRING는 받아온 데이터를 state의 boards에 넣어줌
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    requestBoardToSpring ({ commit }, boardId) {
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
                //boardId로 스프링에서 findById로 데이터 찾아온것을 받아오는 것
                //그 데이터 res.data는 state의 board에 넣는다.
            })
    },
    requestCreateBoardToSpring ({}, payload) {
        //payload는 우리가 보낼 데이터를 의미한다.

        const { title, content, writer } = payload
        //객체화 된 title, content, writer을 /jpa-board/register로 보내 registerBoard를 통해 게시물 등록하도록 함

        return axiosInst.post('/jpa-board/register', { title, content, writer })
            .then((res) => {
                alert('게시물 등록 성공!')
                return res
            })//등록 실패시 문제 발생 표출
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestDeleteBoardToSpring ({}, boardId) {
        return axiosInst.delete(`/jpa-board/${boardId}`)
        //axios.delete는 삭제하라는 요청 
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },

requestBoardModifyToSpring ({}, payload) {
    const { title, content, boardId, writer } = payload
    //역시 payload는 우리가 보낼 데이터를 뜻함

    console.log("title: " + title + ", content: " + content + 
                ", writer: " + writer + ", boardId: " + boardId)

    return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
        .then((res) => {
            //axios.put은 수정을 하라는 요청이다. 해당 id의 데이터를 다시 보내는 payload로 수정해라!
            alert("수정 성공!")
        })
        .catch(() => {
            alert('문제 발생!')
        })
}}