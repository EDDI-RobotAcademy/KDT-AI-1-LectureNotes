import { ActionContext } from 'vuex'
import { BoardState, Board } from './states'
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'
import axiosInst from '../../utility/axiosInstance'
import { AxiosResponse } from 'axios'

export type BoardActions = {
    requestBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void>
    requestCreateBoardToSpring(context: ActionContext<BoardState, unknown>, payload: {
        title: string, content: string, writer: string
    }): Promise<AxiosResponse>
    requestDeleteBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestModifyBoardToSpring(context: ActionContext<BoardState, any>, payload: {
        title: string, content: string, writer: string, boardId: number
    }): Promise<void>
}

const actions: BoardActions = {
    async requestBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void> {
        try {
            const res: AxiosResponse<Board> = await axiosInst.springAxiosInst.get(`/jpa-board/${boardId}`)
            context.commit(REQUEST_BOARD_TO_SPRING, res.data)
        } catch (error) {
            alert('requestBoardToSpring() 문제 발생!')
            throw error
        }
    },
    async requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void> {
        try {
            const res: AxiosResponse<any, any> = await axiosInst.springAxiosInst.get('/jpa-board/list')
            const data: Board[] = res.data
            context.commit(REQUEST_BOARD_LIST_TO_SPRING, data)
        } catch (error) {
            console.error('requestBoardListToSpring(): ' + error)
            throw error
        }
    },
    async requestCreateBoardToSpring(context: ActionContext<BoardState, unknown>, payload: {
        title: string, content: string, writer: string
    }): Promise<AxiosResponse> {

        const { title, content, writer } = payload

        try {
            const res: AxiosResponse = await axiosInst.springAxiosInst.post('/jpa-board/register', { title, content, writer })
            return res.data
        } catch (error) {
            alert('requestCreateBoardToSpring() 문제 발생')
            throw error
        }
    },
    async requestDeleteBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void> {
        try {
            await axiosInst.springAxiosInst.delete(`/jpa-board/${boardId}`)
            alert('삭제 성공!')
        } catch (error) {
            alert('requestDeleteBoardToSpring() 문제 발생')
            throw error
        }
    },
    async requestModifyBoardToSpring(context: ActionContext<BoardState, any>, payload: {
        title: string, content: string, writer: string, boardId: number
    }): Promise<void> {

        const { title, content, writer, boardId } = payload

        try {
            await axiosInst.springAxiosInst.put(`/jpa-board/${boardId}`, { title, content, writer })
            alert('수정 성공!')
        } catch (error) {
            alert('requestModifyBoardToSpring() 문제 발생')
            throw error
        }
    }
}

export default actions