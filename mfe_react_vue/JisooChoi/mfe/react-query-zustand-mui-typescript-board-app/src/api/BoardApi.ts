import { UseMutationResult, UseQueryResult, useQuery, QueryClient, useQueryClient, useMutation } from 'react-query';
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

export const deleteBoard = async (boardId: string): Promise<void> => {
  await axiosInst.springAxiosInst.delete(`/jpa-board/${boardId}`)
}