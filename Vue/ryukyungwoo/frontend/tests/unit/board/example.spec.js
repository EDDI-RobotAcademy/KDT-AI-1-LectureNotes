import { shallowMount } from '@vue/test-utils'
//import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'
import BoardListForm from '@/components/board/BoardListForm.vue'
import BoardReadForm from '@/components/board/BoardReadForm.vue'
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'

import { __createMocks as createBoardStoreMocks } from '@/store/board/__mocks__'
import Vuetify from 'vuetify'

jest.mock('@/store/board/BoardModule')
// @DisplayName
describe('BoardListForm.vue', () => {
  it('게시물 조회할 때 요청 props 일치 여부 검증', () => {
    let board = new Array()
    board.id = 1
    board.title = "go",
    board.writer = "go",
    board.content = "go",
    board.createDate = new Date()

    const wrapper = shallowMount(BoardListForm, {
      propsData: { boards: board }
    })
    expect(wrapper.props().boards).toBe(board)
  })
})

describe('BoardReadForm.vue', () => {
    it('게시물 읽을 때 요청 props 일치 여부 검증', () => {
      let board = new Array()
      board.id = 1
      board.title = "go",
      board.writer = "go",
      board.content = "go",
      board.createDate = new Date()
  
      const wrapper = shallowMount(BoardReadForm, {
        propsData: { board: board }
      })
      expect(wrapper.props().board).toBe(board)
    })
  })
  
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

  describe('requestBoardListToSpring', () => {
    test('Spring에 게시물 리스트 요청 검증', async () => {
      const storeMock = createBoardStoreMocks()
  
      await expect(storeMock.actions.requestBoardListToSpring().length).toStrictEqual(3)
    })
  })

  describe('requestBoardToSpring', () => {
    test('Spring에 게시물 읽기 요청 검증', async () => {
      const storeMock = createBoardStoreMocks()
      const boardId = 1
  
      let board = new Object()
      board.boardId = 1
      board.title = "title"
      board.writer = "writer"
      board.content = "content"
      board.createDate = new Date('2023-07-11')
  
      await expect(storeMock.actions.requestBoardToSpring({ boardId })).toStrictEqual([board])
    })
  })

  describe('requestDeleteBoardToSpring', () => {
    test('Spring에 게시물 삭제 요청 검증', async () => {
      const storeMock = createBoardStoreMocks()
      const boardId = 1
  
      await expect(storeMock.actions.requestDeleteBoardToSpring({ boardId })).toStrictEqual(true)
    })
  })

  describe('requestBoardModifyToSpring', () => {
    test('Spring에 게시물 수정 요청 검증', async () => {
      const storeMock = createBoardStoreMocks()
      const boardId = 1
      const title = "change"
      const content = "change"
  
      let board = new Object()
      board.boardId = 1
      board.title = "change"
      board.writer = "writer"
      board.content = "change"
      board.createDate = new Date('2023-07-11')
  
      await expect(storeMock.actions.requestBoardModifyToSpring({ title, content, boardId })).toStrictEqual([board])
    })
  })