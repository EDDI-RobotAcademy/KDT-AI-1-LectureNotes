import { createStore, Store } from 'vuex'
import { InjectionKey } from 'vue'

import boardModule from './board/boardModule';

// Type을 명시한다면 아래와 같음 (그러나 너무 과함) ->
// TypeScript의 장점이 불명확한한 Type을 명시하자임 -> 무엇이든 과하면 독이 된다 ?

// import { BoardState } from './board/states';
// import { BoardMutations } from './board/mutations';
// import { BoardActions } from './board/actions';

// export type AppStore = Store<RootState> & {
//   getters: {
//     boardModule: BoardState
//   }
//   commit<K extends keyof BoardMutations> (
//     key: K,
//     payload: Parameters<BoardMutations[K]>[1]
//   ): ReturnType<BoardMutations[K]>
//   dispatch<K extends keyof BoardActions>(
//     key: K,
//     payload?: Parameters<BoardActions[K]>[1]
//   ): ReturnType<BoardActions[K]>
// }

// export const storeKey: InjectionKey<AppStore> = Symbol('AppStore')

// 이게 Single Service App이면 필요할지도 모르겠음
export interface RootState { }

export default createStore<RootState>({
  modules: {
    boardModule,
  },
})

export { boardModule }