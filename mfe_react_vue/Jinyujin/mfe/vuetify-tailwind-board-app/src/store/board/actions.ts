import { ActionContext } from 'vuex'
import { BoardState, Board } from './states'
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING
} from './mutation-types'
import axiosInst from '../../utility/axiosInstances'
import { AxiosResponse } from 'axios' // axios 요청했을 때 돌아오는 정보에 대한 응답

export type BoardActions = {
    requestBoardListToSpring(context: ActionContext<BoardState, any>): void
}

const actions: BoardActions = {
    async requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void>{
        try {
            const res: AxiosResponse<any, any> = await axiosInst.springAxiosInst.get('/jpa-board/list')
            const data: Board[] = res.data
            context.commit(REQUEST_BOARD_LIST_TO_SPRING, data)
        } catch (error) {
            console.error(error)
        }
    }
}

export default actions