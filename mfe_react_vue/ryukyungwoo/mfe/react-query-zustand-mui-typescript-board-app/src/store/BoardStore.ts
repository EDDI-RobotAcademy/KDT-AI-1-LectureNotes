import { create } from 'zustand' // Zustand 라이브러리의 create 함수를 가져옵니다.
import { Board } from "../entity/Board" // Board 타입을 가져옵니다.

// 스토어의 인터페이스를 정의합니다. 상태와 액션 함수에 대한 타입을 지정합니다.
interface BoardState {
    boards: [] // 저장할 boards 상태를 빈 배열로 초기화합니다.
    setBoards: (boards: Board[]) => void 
    // boards 상태를 업데이트하는 setBoards 액션을 정의합니다. 인수로 Board[] 타입을 받습니다.
}   // => void는 여기서 타입스크립트 화살표 함수의 반환타입을 의미합니다. 
    // setBoards: (boards: Board[]) => void는 setBoards라는 함수의 시그니처를 정의하는데, 
    // 이 함수는 Board[] 타입의 인수를 받아서 반환값이 없을 것이라는 것을 명시합니다. 
    // 즉, 이 함수는 입력 받은 Board[] 타입의 값을 사용해 상태를 업데이트하며, 
    // 반환할 필요가 없는 처리를 수행합니다. 
    // 여기서 void는 "아무 것도 반환하지 않는다"는 의미로 사용됩니다.

// create 함수를 사용해 Zustand 스토어를 생성합니다.
// 스토어에 boards 상태를 저장하고 setBoards 액션을 사용하여 상태를 업데이트합니다.
export const useBoardStore = create<BoardState>((set) => ({
    boards: [], // 초기 boards 상태값을 빈 배열로 설정합니다.
    setBoards: (boards) => set({ boards }), // setBoards 액션을 정의하여 boards 상태를 업데이트합니다.
}))
// setBoards: (boards) => set({ boards }),에는 
// 인자 boards에 대한 명시적인 타입 표기가 누락되어 있습니다. 

// 하지만 이 경우 TypeScript 컴파일러는 앞서 정의한 
// 인터페이스 BoardState에 setBoards 메서드의 시그니처(함수 signature)를 
// 이미 정의했기 때문에 누락된 타입 표기를 추론합니다. 

// BoardState에서 선언한 메서드 시그니처는 다음과 같이 되어 있습니다.
// setBoards: (boards: Board[]) => void
// 따라서 TypeScript는 함수 시그니처에 명시된 대로 인자 boards가 Board[] 타입임을 알 수 있습니다.

// 불행히도 코드 양식이나 일관성을 위하여 인자 타입을 명시적으로 적어두는 것이 좋습니다.

// setBoards: (boards: Board[]) => set({ boards }),
// 위와 같이 작성하여 추후 코드를 읽거나 작성할 때 혼란을 줄일 수 있습니다.

// 생성한 스토어를 export 하여 다른 컴포넌트에서 사용할 수 있게 합니다.
export default useBoardStore
