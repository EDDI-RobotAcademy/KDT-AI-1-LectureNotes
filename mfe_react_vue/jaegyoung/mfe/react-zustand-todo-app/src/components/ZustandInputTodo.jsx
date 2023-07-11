import React, { useState } from 'react'
import { FaPlusCircle } from 'react-icons/fa'
import { useTodoStore } from '../zustand/store'

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
        setMessage('올바르게 입력 해주세요')
    }
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input
            type="text"
            placeholder='todo 입력'
            value={title}
            onChange={handleChange}/>
        <button>
          <FaPlusCircle
            style={{ color: '', fontSize: '12px', marginTop: '2px' }}/>
        </button>
      </form>
      <span>{ message }</span>
    </div>
  )
}

export default ZustandInputTodo