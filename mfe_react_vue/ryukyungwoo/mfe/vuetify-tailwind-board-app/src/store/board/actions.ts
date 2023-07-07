import { ActionContext } from 'vuex'
import { BoardState, Board } from './states'

// mutation-types 파일에서 내보낸 mutation type을 가져온다.
import {
    REQUEST_BOARD_LIST_TO_SPRING,
    REQUEST_BOARD_TO_SPRING,
} from './mutation-types'

// utility 폴더에 있는 axiosInstance 파일을 임포트하여 사용한다.
import axiosInst from '../../utility/axiosInstance'

import { AxiosResponse } from 'axios'

// BoardActionTypes는 Vuex에서 사용될 액션들의 타입을 정의해준다.
export type BoardActions = {
    // export type BoardActions는 TypeScript에서 Interface를 사용하여 만든 custom data type입니다.     
    // 이 경우, Vuex store의 'actions' 모듈이 갖춰야할 액션함수의 타입을 정의합니다. 

    // BoardActions는 객체형태를 띄며, 하나의 프로퍼티 requestBoardListToSpring를 갖고 있습니다. 
    // 해당 프로퍼티가 담은 데이터 타입은 ActionContext<BoardState, any>이며 
    // 반환타입은 'void'로 설정되어 있습니다. 

    // ActionContext 객체는 Vuex에서 사용하는 객체로서, 
    // 액션 함수 내에서 state, mutations, getters를 commit, dispatch할 수 있는 친구입니다. 
    // BoardState는 Vuex state의 타입입니다. 'any' 타입은 플러그인과의 호환성을 위해 사용한 것입니다. 

    // 즉, 이 코드에서 requestBoardListToSpring 함수는 
    // ActionContext 타입의 context 객체를 인자로 받아 Vuex 상태를 변경하는 역할을 하게 됩니다. 
    // context 인자 안에는 state, commit, dispatch, getters 등을 사용할 수 있는데 
    // 이들을 사용하여 store의 state를 변경하거나, action을 호출하거나, getter를 불러오는 등에 사용합니다.
    requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void>
    requestCreateBoardToSpring(context: ActionContext<BoardState, unknown>, payload: {
        title: string, content: string, writer: string
    }): Promise<AxiosResponse>
    requestBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestDeleteBoardToSpring(context: ActionContext<BoardState, any>, boardId: number): Promise<void>
    requestModifyBoardToSpring(context: ActionContext<BoardState, any>, payload: {
        title: string, content: string, writer: string, boardId: number
    }): Promise<void>

    // 비동기 함수의 경우 반환 값으로 Promise를 반환합니다. 
    // 비동기 함수는 작업이 완료될 때까지 기다리지 않고 바로 반환하며, 
    // 반환 되는 값을 기다릴 필요가 있는 경우에 Promise를 사용합니다. 
    // Promise<void>는 비동기 함수가 완료된 후 반환 값이 없음을 나타냅니다. 
    // 작업 결과에 관심이 없고, 작업 완료를 알리는 것만이 필요한 경우에 사용됩니다.
    // 따라서 Promise<void>를 사용하는 이유는 
    // 비동기 함수에서 작업 완료를 알리기 위해 Promise를 반환하면서, 
    // 반환 값에 관심이 없는 경우에 적합하기 때문입니다.
}   

// actions는 BoardActions 타입의 객체를 담고 있다.
const actions: BoardActions = {
    // requestBoardListToSpring은 ActionContext 객체를 인수로 받는 비동기 함수로서,
    // API 요청을 보내는 메소드이다.
    // Promise<void>는 비동기와 관련된 리턴 타입입니다. 

    // 여기서 requestBoardListToSpring은 Promise를 반환하고 있습니다. 
    // 'void' 타입은 반환하는 데이터가 없음을 의미합니다. 
    // 즉, 이 액션 함수는 state를 변경만 해주는 역할을 합니다. 
    async requestBoardListToSpring(context: ActionContext<BoardState, any>): Promise<void> {
        try {
            // Axios 모듈을 사용하여 /jpa-board/list 주소에 GET 요청을 전송한다.
            // 'AxiosResponse'를 사용하면 해당 요청의 응답 데이터의 타입을 정의할 수 있습니다.

            // 첫 번째 제네릭 인자로는 응답(Response) 데이터의 타입을, 
            // 두 번째 인자로는 HTTP 요청(Rquest) 데이터의 타입을 지정할 수 있습니다.

            // HTTP GET 요청에 대한 반환값의 타입은 Response 데이터 타입인 AxiosResponse<any> 입니다. 
            // 두 번째 인자로 any를 전달하는 이유는 요청(Request)에 대한 데이터를 사용하지 않기 때문입니다. 
            // 따라서 const res: AxiosResponse<any, any>는 
            // GET 요청에 대한 응답 데이터의 타입이 any인 AxiosResponse 객체를 만들어주는 코드입니다.
            const res: AxiosResponse<any, any> = await axiosInst.springAxiosInst.get('/jpa-board/list')
            // 반환된 데이터를 가공하여 타입이 맞는 배열로 변환한다.
            const data: Board[] = res.data
            // 변환된 데이터를 mutation으로 보내 상태(state)를 변경한다.
            context.commit(REQUEST_BOARD_LIST_TO_SPRING, data)
        } catch (error) {
            console.error('requestBoardListToSpring(): ' + error)
            throw error
        }
    },
    async requestCreateBoardToSpring(context: ActionContext<BoardState, unknown>, payload: {
        title: string, content: string, writer: string
    }): Promise<AxiosResponse> {

        const {title,content,writer} = payload

        try {
            const res: AxiosResponse = await axiosInst.springAxiosInst.post('/jpa-board/register', {title, writer, content})
            return res.data
        } catch (error) {
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

// actions를 모듈로 내보낸다.
export default actions
