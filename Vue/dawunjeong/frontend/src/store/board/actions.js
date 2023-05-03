// actions에서는 mutation-types를 import하여 사용합니다.
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

/*
axiosInst를 사용함으로써 htt://~~~~~라고 길게 URL을 적지 않아도 됩니다.
baseURL: 'http://localhost:7777'라고 설정해주었기 때문에 이 뒤로 오는 경로만 지정해주면 됩니다.
*/
import axiosInst from '@/utility/axiosInst'

/*
액션에서 commit 매서드를 사용하면
mutation을 호출하여 그 기능을 사용할 수 있습니다.

액션의 기본 구조 : 액션명({액션의 매서드}, 인자) {실행 코드}
*/

export default {
    /*
    이 액션을 호출할 때 입력받는 boardId는 axiosInst.get에서 url로 사용됩니다.
    ${boardId}라고 적어준 이유는 마지막 경로인 boardId 부분이 변경될 수 있다고 명시해준 것입니다.
    이렇게 가변 url을 지정해줄 때는 ''이 아닌 ``를 사용해야 합니다.

    commit 매서드에 의해 REQUEST_BOARD_TO_SPRING이라는 mutation이 호출되고
    axiosInst.get으로부터 받아온 응답 데이터가 REQUEST_BOARD_TO_SPRING을 실행하는데 사용됩니다.
    */
    requestBoardToSpring ({ commit }, boardId) {
        return axiosInst.get(`/jpa-board/${boardId}`)
            .then((res) => {
                commit(REQUEST_BOARD_TO_SPRING, res.data)
            })
    },
    requestBoardListToSpring ({ commit }) {
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