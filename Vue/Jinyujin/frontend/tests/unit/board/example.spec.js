import { shallowMount } from '@vue/test-utils'
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
// import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue' // vuetify 테스트
import BoardListForm from '@/components/board/BoardListForm.vue'
import BoardReadForm from '@/components/board/BoardReadForm.vue'

import { __createMocks as createBoardStoreMocks } from '@/store/board/__mocks__'
import Vuetify from 'vuetify'

jest.mock('@/store/board/BoardModule')

// @DisplayName
describe('BoardListForm.vue axios 테스트', () => {
  it('게시물 조회할 때 요청 props 일치 여부 검증', () => {
    let board = new Array()
    board.id = 1
    board.title = "go"
    board.writer = "go"
    board.content = "go"
    board.regDate = new Date()

    const wrapper = shallowMount(BoardListForm, {
      propsData: { boards: board }
    })
    expect(wrapper.props().boards).toBe(board) // props의 boards가 board랑 일치하는지 볼 것
  })
})

describe('BoardReadForm.vue axios 테스트', () => {
  it('게시물 읽을 때 요청 props 일치 여부 검증', () => {
    let board = new Array()
    board.id = 1
    board.title = "go"
    board.writer = "go"
    board.content = "go"
    board.regDate = new Date()

    const wrapper = shallowMount(BoardReadForm, {
      propsData: { board: board }
    })
    expect(wrapper.props().board).toBe(board) // read할 때는 필요한 props가 id였음(board 전체를 받는 것 확인)
  })
})

// 여기서는 실질적인 actions을 검증(Register)
describe('requestCreateBoardToSpring', () => {
  test('Spring에 게시물 작성 요청 검증', async () => {
    const storeMock = createBoardStoreMocks()

    const title = "title"
    const writer = "writer"
    const content = "content"

    let board = new Object()
    board.id = 1
    board.title = "title"
    board.writer = "writer"
    board.content = "content"

    await expect(storeMock.actions.requestCreateBoardToSpring({ title, writer, content })).toStrictEqual(board)
  })
})