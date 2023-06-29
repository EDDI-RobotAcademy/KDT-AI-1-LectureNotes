export interface BoardState {
    boards: Board[]
    board: Board | null
}

// 타입을 지정 Board의 entity와 동일해져서 명확해짐
export interface Board {
    boardId: number
    title: string
    writer: string
    content: string
    createDate: string
    updateDate: string
}

const state: BoardState = {
    boards: [],
    board: null
}

export default state