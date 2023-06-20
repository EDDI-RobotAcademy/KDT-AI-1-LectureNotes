import React, { useState } from 'react'

// rafce
const Counter = () => {
  // count는 vue의 state
  // setCount는 vue의 action
  // useState를 통해 count를 초기값 0으로 설정
  const [count, setCount] = useState(0)

  const onIncrement = () => setCount(count + 1)
  const onDecrement = () => setCount(count - 1)

  return (
    <div>
      <h1>나는 React Counter!</h1>
      <p>현재 count: <strong>{ count }</strong></p>
      <button style={{height:'50px', width:'50px', fontSize:'30px', position:'relative'}}onClick={onIncrement}>+</button>
      <button style={{height:'50px', width:'50px', fontSize:'30px', position:'relative'}}onClick={onDecrement}>-</button>
    </div>
  )
}

export default Counter