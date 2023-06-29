import { Board } from "../entity/Board"
import { create } from "zustand"

interface BoardState {
    boards: []
    setBoards: (boards: Board[]) => void
}

export const useBoardStore = create<BoardState>((set)=>({
    boards: [],
    setBoards: (boards) => set ({ boards })
}))

export default useBoardStore