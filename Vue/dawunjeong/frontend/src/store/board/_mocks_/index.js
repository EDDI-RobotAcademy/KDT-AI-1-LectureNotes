import Vue from 'vue'
import Vuex from 'vuex'
import axiosInst from '@/utility/axiosInst'

Vue.use(Vuex)

export const getters = {
    getBoards: jest.fn().mockReturnValue([
        {
            boardId: 1,
            title: "go",
            writer: "go",
            content: "go",
            createDate: new Date('2023-07-11'),
        },
        {
            boardId: 2,
            title: "go",
            writer: "go",
            content: "go",
            createDate: new Date('2023-07-11'),
        },
        {
            boardId: 3,
            title: "go",
            writer: "go",
            content: "go",
            createDate: new Date('2023-07-11'),
        }
    ]),

    getBoard: jest.fn().mockReturnValue([
        {
            boardId: 1,
            title: "title",
            writer: "writer",
            content: "content",
            createDate: new Date('2023-07-11'),
        }
    ])
}

export const mutations = {
    fetch: jest.fn(),
}

export const actions = {
    requestCreateBoardToSpring: jest.fn((payload) => {
        const { title, writer, content } = payload

        let board = new Object()
        board.id = 1
        board.title = title
        board.writer = writer
        board.content = content

        return board
    }),

    requestBoardListToSpring: jest.fn(() => {
        return getters.getBoards()
    }),

    requestBoardToSpring: jest.fn((payload) => {
        const { boardId } = payload
        return getters.getBoard()
    }),

    requestDeleteBoardToSpring: jest.fn((payload) => {
        const { boardId } = payload

        let board = getters.getBoard()

        if(board[0].boardId == boardId) {
            return true
        }
    }),

    requestBoardModifyToSpring: jest.fn ((payload) => {
        const { title, content, boardId } = payload

        let board = getters.getBoard()

        if (board[0].boardId === boardId) {
            board[0].title = title
            board[0].content = content
        }

        return board
    }),
}

export const state = {
    
}

export function __createMocks(custom = { getters: {}, mutations: {}, actions: {}, state: {}}) {
    const mockGetters = Object.assign({}, getters, custom.getters)
    const mockMutationss = Object.assign({}, mutations, custom.mutations)
    const mockActions = Object.assign({}, actions, custom.actions)
    const mockState = Object.assign({}, state, custom.state)

    return {
        getters: mockGetters,
        mutations: mockMutationss,
        actions: mockActions,
        state: mockState,
        store: new Vuex.Store({
            getters: mockGetters,
            mutations: mockMutationss,
            actions: mockActions,
            state: mockState
        })
    }
}

export const store = __createMocks().store