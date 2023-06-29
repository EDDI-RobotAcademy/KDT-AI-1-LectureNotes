import { UseMutationResult, UseQueryResult, useMutation, useQuery, useQueryClient } from 'react-query'
import axiosInst from '../utility/axiosInstance'
import { Board } from '../entity/Board'
import useBoardStore from '../store/BoardStore'

export const fetchBoardList = async (): Promise<Board[]> => {
    const response = await axiosInst.springAxiosInst.get<Board[]>('/jpa-board/list')
    return response.data
}

export const useBoardListQuery = (): UseQueryResult<Board[], unknown> => {
    const setBoards = useBoardStore((state) => state.setBoards)

    const queryResult: UseQueryResult<Board[], unknown> = useQuery('boardList', fetchBoardList, {
        onSuccess: (data) => {
            setBoards(data)
        }
    })

    return queryResult
}
// ↑ 간단하게 우리는 여기서 acions 을 만들었다고 생각하면 된다.

export const registerBoard = async (
    data: { title: string; writer: string; content: string }
): Promise<Board> => {
    const response = await axiosInst.springAxiosInst.post<Board>('/jpa-board/register', data)
    return response.data
}

export const fetchBoard = async (boardId: string): Promise<Board | null> => {
    const response = await axiosInst.springAxiosInst.get<Board>(`/jpa-board/${boardId}`)
    return response.data
}

export const useBoardQuery = (boardId: string): UseQueryResult<Board | null, unknown> => {
    return useQuery(['board', boardId], () => fetchBoard(boardId))
}
// ↑ register, list 및 read 페이지 구현하면서 만들었던 action

export const updateBoard = async (updatedData: Board): Promise<Board> => {
    const { boardId, title, content, writer } = updatedData
  
    const response = await axiosInst.springAxiosInst.put<Board>(
      `/jpa-board/${boardId}`, { title, content, writer })
  
    return response.data
  }

export const useBoardUpdateMutation = (): UseMutationResult<Board, unknown, Board> => {
    const QueryClient = useQueryClient()

    return useMutation (updateBoard, {
        onSuccess: (data) => {
            QueryClient.setQueryData(['board', data.boardId], data)
        }
    })

}