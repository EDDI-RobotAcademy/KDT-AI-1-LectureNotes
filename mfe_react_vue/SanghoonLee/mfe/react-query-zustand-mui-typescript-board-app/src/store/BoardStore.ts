import { create } from 'zustand'
import { Board } from "../entity/Board"

interface BoardState {
    boards: []
    setBoards: (boards: Board[]) => void
}

export const useBoardStore = create<BoardState>((set) => ({
    boards: [],
    setBoards: (boards) => set({ boards }),
}))

export default useBoardStore