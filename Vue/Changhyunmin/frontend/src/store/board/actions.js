//Spring의 내용을 받아온다.
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'
//'./mutation-types의 내용물을 갖고온다.
import axiosInst from '@/utility/axiosInst'
//axiosInst와 연결한다
export default {
    requestBoardToSpring ({ commit }, boardId) {
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    /*
    Spring 도메인에 있는 /jpa-board/ 자료를 불러온다
    주 흐름 => 명칭 ({commit}){return 도메인.get('부르고 싶은 Spring 도메인').then((res)=>{commit(연결하고 싶은 파일, res.data)})}
    ex) =>requestBoardListToSpring ({ commit }) { return axiosInst.get ('/jpa-board/list').then((res) => { commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)})},
    */
   //
    requestBoardListToSpring ({ commit }) {
        axiosInst.get('/jpa-board/list')
            .then((res) => {
                commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
            })
    },
    //생성 도메인(register)
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
    //삭제 도메인
    requestDeleteBoardToSpring ({}, boardId) {
        return axiosInst.delete(`/jpa-board/${boardId}`)
            .then((res) => {
                alert('삭제 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    //수정 도메인
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