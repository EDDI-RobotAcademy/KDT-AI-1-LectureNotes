import { createStore, Store } from 'vuex'
import { InjectionKey } from 'vue'

import boardModule from './board/boardModule';

import { BoardState } from './board/states';
import { BoardMutations } from './board/mutations';
import { BoardActions } from './board/actions';

// 이게 Single Service App이면 필요할지도 모르겠음
export interface RootState { }

export type AppStore = Store<RootState> & {
  getters: {
    boardModule: BoardState
  }
  commit<K extends keyof BoardMutations> (
    key: K,
    payload: Parameters<BoardMutations[K]>[1]
  ): ReturnType<BoardMutations[K]>
  dispatch<K extends keyof BoardActions>(
    key: K,
    payload?: Parameters<BoardActions[K]>[1]
  ): ReturnType<BoardActions[K]>
}

export const storeKey: InjectionKey<AppStore> = Symbol('AppStore')

export default createStore<RootState>({
  modules: {
    boardModule,
  },
})

export { boardModule }