import {
    REQUEST_BOARD_LIST_TO_SPRING,
} from './mutation-types'

export default {
    namespaced: true,
    state: () => ({
        boards: [],
        board: {},
    }),
    actions: {
        requestBoardListToSpring ({ commit }) {
            axiosInst.get('/jpa-board/list')
                .then((res) => {
                    commit(REQUEST_BOARD_LIST_TO_SPRING, res.data)
                })
        },
    },
    mutations: {
        [REQUEST_BOARD_LIST_TO_SPRING] (state, receivedData) {
            state.boards = receivedData
        },
    },
}