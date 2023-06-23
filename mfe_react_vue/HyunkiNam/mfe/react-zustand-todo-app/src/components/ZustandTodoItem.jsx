import React, { useRef, useState } from 'react'
import { useTodoStore } from '../zustand/store'

import { AiFillEdit } from 'react-icons/ai'
import { FaTrash } from 'react-icons/fa'

const ZustandTodoItem = ({ props }) => {
  const [editing, setEditing] = useState(false)

  const handleChange = useTodoStore((state) => state.handleChange)
  const deleteTodo = useTodoStore((state) => state.deleteTodo)
  const setUpdate = useTodoStore((state) => state.setUpdate)

  const editInputRef = useRef(null)

  const handleEditing = () => {
    setEditing(true)
  }

  const handleUpdatedDone = (event) => {
    if (event.key === 'Enter') {
      setUpdate(editInputRef.current.value, props.id)
      setEditing(false)
    }
  }

  return (
    <li>
      <div>
        <input type="checkbox" checked={props.completed} onChange={() => handleChange(props.id)} />
        <button onClick={handleEditing}>
          <AiFillEdit style={{ color: '#64B5F6', fontSize: '16px' }} />
        </button>
        <button onClick={() => deleteTodo(props.id)}>
          <FaTrash style={{ color: '', fontSize: '16px' }} />
        </button>
        <span>
          {props.title}
        </span>
      </div>
      {editing && <input type="text" ref={editInputRef} defaultValue={props.title} onKeyDown={handleUpdatedDone} />}
    </li>
  )
}

export default ZustandTodoItem