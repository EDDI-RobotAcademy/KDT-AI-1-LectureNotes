import React, { useState } from 'react' // imr
// Extentions -> ES7 repository 들어가서 docs 들어가서 키워드 살펴보심

// rafce(import React부분은 지움)
const Counter = () => {
    // count는 vue의 state
    // setcount는 vue의 action
    // useState를 통해 count를 초기값 0으로 설정
    const [count, setCount] = useState(0)

    const onIncrement = () => setCount(count + 1)
    const onDecrement = () => setCount(count - 1)

  return (
    <div>
        <h1>나는 React Counter!</h1>
          <p>현재 count: <strong>{count}</strong></p>
          {/* strong 태그는 단순 강조뿐만이 아니라 이 부분이 중요하다는 사실을
          브라우저에 전달해주는 역할을 한다고 함 */}
        <button onClick={onIncrement}>+</button>
        <button onClick={onDecrement}>-</button>
        {/* <button onClick={onIncrement}>+</button>
        <button onClick={onDecrement}>-</button> */}
    </div>
  )
}

export default Counter
// 위 export를 주석처리하면 contianer-app/App에서
// navigation을 import 했던 것처럼 해줬어야 함
// 지금은 이 방식이 깔끔하니 그냥 놔둠
// 해당 사항은 Micro Frontend 이슈에 있음 
// export 방식에 따라 import할 때 차이가