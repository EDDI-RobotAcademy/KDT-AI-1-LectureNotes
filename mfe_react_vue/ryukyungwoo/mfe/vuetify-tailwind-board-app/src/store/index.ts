// Vuex 모듈과 타입, Vuex 상태 객체의 모듈에서 불러온 타입들을 import 합니다.
import { createStore, Store } from 'vuex'
import { InjectionKey } from 'vue'
import boardModule from './board/boardModule';
import { BoardState } from './board/states';
import { BoardMutations } from './board/mutations';
import { BoardActions } from './board/actions';

// Root 상태 객체를 생략하고, getters에서 boardModule을 가져오는 방식으로 타입 별명을 지정합니다.
export interface RootState { }
export type AppStore = Store<RootState> & {
    getters: {
      boardModule: BoardState
    }

  // commit 메서드의 dispatch 메서드와 바인딩 된 제네릭 매개변수입니다.
    commit<K extends keyof BoardMutations> (
      key: K,
      // [REQUEST_BOARD_LIST_TO_SPRING] (state: BoardState, receivedData: Board[]): void
      // [REQUEST_BOARD_TO_SPRING] (state: BoardState, receivedData: Board): void
      // payload: Parameters<BoardMutations[K]>[1]는 2번째 인자를 payload로 하기 때문에
      // 2번째 인자인 receivedData: Board[]가 payload가 된다
      payload: Parameters<BoardMutations[K]>[1]
    ): ReturnType<BoardMutations[K]>

  // dispatch 메서드의 dispatch 메서드와 바인딩 된 제네릭 매개변수입니다.
    dispatch<K extends keyof BoardActions>(
      key: K,
      payload?: Parameters<BoardActions[K]>[1]
    ): ReturnType<BoardActions[K]>
}

// Vuex 스토어의 InjectionKey 인터페이스를 구현합니다.
export const storeKey: InjectionKey<AppStore> = Symbol('AppStore')

// Vuex의 createStore 메소드를 통해 Root State 객체를 생성하며, boardModule을 하나의 Vuex 모듈로 등록합니다.
export default createStore<RootState>({
  modules: {
    boardModule,
  },
})

// boardModule을 export 합니다.
export { boardModule }
