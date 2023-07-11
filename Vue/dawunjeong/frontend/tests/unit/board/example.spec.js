import { shallowMount } from '@vue/test-utils'
import GlobalComponent from '@/components/componentTest/GlobalComponent.vue'
//import TableAdvanced from '@/views/uiVuetify/TableAdvanced.vue'
import BoardListForm from '@/components/board/BoardListForm.vue'

import { __createMocks as createBoardStoreMocks } from '@/store/board/_mocks_'
import Vuetify from 'vuetify'

jest.mock('@/store/board/BoardModule')

describe('BoardListForm.vue', () => {
  it('게시판 조회할 때 요청 props 일치 여부 검증', () => {
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
