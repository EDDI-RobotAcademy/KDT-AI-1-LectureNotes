import { UseQueryResult, useQuery } from 'react-query'
import axiosInst from '../utility/axiosInstance'
import { Board } from '../entity/Board'
import useBoarStore from '../store/BoardStore'

export const fetchBoardList = async (): Promise<Board[]> => {
  const response = await axiosInst.springAxiosInst.get<Board[]>('jpa-board/list')
  return response.data
}

export const useBoardListQuery = (): UseQueryResult<Board[], unknown> => {
  const setBoards = useBoarStore((state) => state.setBoards)

  const queryResult: UseQueryResult<Board[], unknown> = useQuery('boardList', fetchBoardList, {
    onSuccess: (data) => {
      setBoards(data)
    }
  })

  return queryResult
}

export const registerBoard = async (
  data: { title: string; writer: string; content: string } // payload 형식
) : Promise<Board> => {
  const response = await axiosInst.springAxiosInst.post<Board>('/jpa-board/register', data)
  return response.data
}