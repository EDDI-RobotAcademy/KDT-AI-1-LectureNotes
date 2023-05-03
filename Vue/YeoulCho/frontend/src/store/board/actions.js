import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    //액션에서 commit 메서드 사용하여 mutation을 호출할 수 있다.
    //액션의 기본 구조 : 액션명({액션의 메서드}, 인자) {실행 코드}
    requestBoardToSpring ({commit}, boardId) {
        //이렇게 가변 url을 지정해줄 때는 ''이 아닌 ``를 사용
        //${boardId} : 가변인자라는 것 표시
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
                //commit이란 state에 값을 넣는작업
                //mutation의 REQUEST_BOARD_TO_SPRING 메서드 호출하여 
                //axiosInst를 통해 받은 데이터로 변경 
            })
    },
    requestBoardListToSpring ({ commit }) {
        //스프링에게 JpaBoard에 작성된 리스트를 요청
        axiosInst.get('/jpa-board/list')
            .then((res) => {
                //받은 데이터
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
                //받은 데이터는 state의 REQUEST_BOARD_LIST_TO_SPRING에서 변경
            })

        console.log(axiosInst.get('/jpa-board/list')
        .then((res) => {
            //받은 데이터
            commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            //받은 데이터는 state의 REQUEST_BOARD_LIST_TO_SPRING에서 변경
        }))
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
        axiosInst.delete(`/jpa-board/${boardId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestBoardModifyToSpring ({}, payload) {
        const { title, content, boardId, writer } = payload //전송할 데이터

        console.log("title: " + title + ", content: " + content + 
                    ", writer: " + writer + ", boardId: " + boardId)

        return axiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
        //writer는 사실 필요없음
        //그러나 지금 form이 이미 정해져있어서 넣어야함
            .then((res) => {
                alert("수정 성공!")
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}