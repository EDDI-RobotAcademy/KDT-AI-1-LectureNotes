export interface BoardState {
  boards: Board[]
  board: Board | null
}

export interface Board {
  boardId: number
  title: string
  writer: string
  content: string
  creatDate: string
  updateDate: string
  // Board type을 지정하는 것
}

const state: BoardState = {
  // state 타입이 BoardState 라는 것 
  boards: [],
  board: null
}

export default state