import { MutationTree } from 'vuex'
import { BoardState, Board } from './states'
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

// mutations의 인터페이스 정의
export interface BoardMutations extends MutationTree<BoardState> {
    [REQUEST_BOARD_LIST_TO_SPRING] (state: BoardState, receivedData: Board[]): void
    [REQUEST_BOARD_TO_SPRING] (state: BoardState, receivedData: Board): void
}

// mutations 객체 정의

// MutationTree는 Vuex에서 제공하는 Generic Interface입니다. 
// Vuex 스토어의 mutation 메소드는 첫 번째 인자로 상태(state)를 받습니다. 
// 이때 받을 수 있는 객체의 타입에 대한 '보장'을 하기 위해 MutationTree를 사용합니다. 
// MutationTree는 일종의 제네릭 인터페이스로, 제네릭 타입으로는 상태 객체(state)를 받습니다. 
// MutationTree 인터페이스는 Vuex에서 state를 변경하는 데 사용되는 methods와 
// 기능 명세서를 묶어놓은 구조체입니다. 
// 이를 통해 Vuex에서 mutation하는 기능을 인터페이스화할 수 있어, 
// type-safe하게 Vuex 작업을 할 수 있는 이점을 가집니다. 
// Vuex에서 mutation 작업을 할 때 MutationTree를 이용하면 제네릭을 이용해 상태 객체의 타입을 지정함으로써, 
// 상태 객체에 알맞은 mutation 작업이 이루어지게 됩니다. 
// 이 역시 type-safe한 Vuex 작업을 위해 필요한 것입니다.

const mutations: MutationTree<BoardState> = {
    // REQUEST_BOARD_LIST_TO_SPRING 함수 정의
    [REQUEST_BOARD_LIST_TO_SPRING] (state: BoardState, receivedData: Board[]): void {
        // state의 boards 속성에 받은 데이터(receivedData)를 할당
        state.boards = receivedData
    },
    // REQUEST_BOARD_TO_SPRING 함수 정의
    [REQUEST_BOARD_TO_SPRING] (state: BoardState, receivedData: Board): void {
        // state의 board 속성에 받은 데이터(receivedData)를 할당
        state.board = receivedData
    }
}

// BoardMutations 형태로 mutations 객체 export
export default mutations as BoardMutations
