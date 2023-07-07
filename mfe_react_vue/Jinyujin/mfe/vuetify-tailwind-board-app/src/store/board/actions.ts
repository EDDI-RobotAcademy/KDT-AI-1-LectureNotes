import { ActionContext } from 'vuex'
import { BoardState, Board } from './states'
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING
} from './mutation-types'
import axiosInst from '../../utility/axiosInstances'
import { AxiosResponse } from 'axios' // axios 요청했을 때 돌아오는 정보에 대한 응답
// import { async } from '../../../../vue-navigation-app/src/plugin/webfontloader';

export type BoardActions = {
    // 여기는 타입 설정
    requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void>
    // ActionContext: 액션에서 스토어의 상태나 다른 액션을 호출하는데 사용됨
    requestCreateBoardToSpring(context: ActionContext<BoardState, unknown>, payload: {
        title: string, content: string, writer: string
    }): Promise<AxiosResponse>
    requestBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestDeleteBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestModifyBoardToSpring(context: ActionContext<BoardState, any>, payload: {
        title: string, content: string, writer: string, boardId: number
    }): Promise<void>
}

const actions: BoardActions = {
    // 여기서 구체적인 액션 설정
    async requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void>{
        try {
            const res: AxiosResponse<any, any> = await axiosInst.springAxiosInst.get('/jpa-board/list')
            const data: Board[] = res.data
            context.commit(REQUEST_BOARD_LIST_TO_SPRING, data)
            // commit으로 상태 업데이트
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
        } catch(error) {
            alert('requestCreateBoardToSpring() 문제 발생')
            throw error
        }
    },
    async requestBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void> {
        try {
            const res: AxiosResponse<Board> = await axiosInst.springAxiosInst.get(`/jpa-board/${boardId}`)
            context.commit(REQUEST_BOARD_TO_SPRING, res.data)
        } catch (error) {
            alert('requestBoardToSpring() 문제 발생!')
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