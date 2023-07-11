import React, { useRef, useState } from 'react'
import { useTodoStore } from '../zustand/store'

import { AiFillEdit } from 'react-icons/ai'
import { FaTrash } from 'react-icons/fa'

const ZustandTodoItem = ({ props }) => {
  const [editing, setEditing] = useState(false)

  // 사실상 Vue의 ...mapMutations() 혹은 ...mapActions()와 동일하다 볼 수 있음
  // 보면 actions 요청인지, state 가져오는지, mutation 작업인지는 결구 우리가 잘 판단해야함
  // 그러므로 Vue 스타일로 이것을 바라본다면 아래와 같이 매서드 명에 구분을 할 수 있도록 만들어주는 수 밖에 없음
  // 네이밍을 할 때 handleChangeForMutation = useTodoStore((state) => state.handleChangeForMutation)
  // 이 스타일을 따라간다면 todosForState = useTodoStore((state) => state.todosForState)
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
        <input type="checkbox" checked={props.completed} onChange={() => handleChange(props.id)}/>
        <button onClick={handleEditing}>
          <AiFillEdit style={{ color: '#64B5F6', fontSize: '16px' }}/>
        </button>
        <button onClick={() => deleteTodo(props.id)}>
          <FaTrash style={{ color: '', fontSize: '16px' }}/>
        </button>
        <span>
          { props.title }
        </span>
      </div>
      <input type="text" ref={editInputRef} defaultValue={props.title} onKeyDown={handleUpdatedDone}/>
    </li>
  )
}

export default ZustandTodoItem