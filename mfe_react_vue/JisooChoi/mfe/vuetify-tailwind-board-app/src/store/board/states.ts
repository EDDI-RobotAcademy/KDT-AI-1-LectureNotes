export interface BoardState {
    boards: Board[]
    board: Board | null
}

// 타입을 지정해주는 인터페이스
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
    board: null,
}

export default state