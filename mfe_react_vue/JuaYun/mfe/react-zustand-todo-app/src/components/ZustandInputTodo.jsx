import React, { useState } from 'react'
import { FaPlusCircle } from 'react-icons/fa'
import { useTodoStore } from '../zustand/store'
// npm install react-icon --save-dev
// npm install zustand --save-dev
// npm install react-icons --save-dev


// 등록
const ZustandInputTodo = () => {
  const [title, setTitle] = useState("")
  const [message, setMessage] = useState("")

  const addTodoItem = useTodoStore((state) => state.addTodoItem)
  const handleChange = (e) => {
    setTitle(e.target.value)
  }

  const handleSubmit = (e) => {
    e.preventDefault()

    if (title.trim()) {
      addTodoItem(title)
      setTitle('')
      setMessage('')
    } else {
      setMessage('올바르게 입력해주세요')
      // 입력창이 비어있는 상태에서 엔터를 누르면 올바르게 입력하라는 문구가 나옴
    }
  }
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder='todo입력' value={title} onChange={handleChange}/>
        <button>
          <FaPlusCircle style={{ color: '', fontSize: '10px', marginTop: '2px'}}/>
        </button>
      </form>
      <span>{ message }</span>
    </div>
  )
}

export default ZustandInputTodo