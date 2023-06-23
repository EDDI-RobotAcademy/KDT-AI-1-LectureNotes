import React, { useState, useRef } from 'react'
import { useTodoStore } from '../zustand/store'

import { AiFillEdit } from 'react-icons/ai'
import { FaTrash } from 'react-icons/fa'

// todo 리스트의 각각의 todo가 표시되도록
const ZustandTodoItem = ({ props }) => {
    const [editing, setEditing] = useState(false)
    // editing 자체를 boolean으로 설정: useState(false)

    // 사실상 Vue의 ...mapMutations() 혹은 ...mapActions()와 동일하다 볼 수 있음
    // 보면 actions 요청인지, state 가져오는지, mutations 작업인지는 결국 우리가 잘 판단해야 함
    // 그러므로 Vue 스타일로 이것을 바라본다면 아래와 같이 메서드 명에 구분을 할 수 있도록 만들어주는 수밖에 없음
    // 네이밍을 할 때 handleChangeForMutation = useTodoStore((state) => state.handleChangeForMutation)
    // 이 스타일을 따라간다면 todoForState = useTodoStore((state) => state.useForState)
    const handleChange = useTodoStore((state) => state.handleChange)
    const deleteTodo = useTodoStore((state) => state.deleteTodo)
    const setUpdate = useTodoStore((state) => state.setUpdate)

    const editInputRef = useRef(null)

    const handleEditing = () => {
        setEditing(!editing)
        // editing 자체가 boolean
        // !editing: true면 false로 만들고 false면 true로 만들도록
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
              {/* <button onClick={handleEditing}> */}
              <button onClick={(() => handleEditing(props.id))}>
                  {/* 수정할 때 버튼 누르면 빈칸 나오도록 */}
                  <AiFillEdit style={{ color: '#64B5F6', fontsize: '16px' }} />
                  {/* AiFillEdit은 아이콘 이름 */}
              </button>
              <button onClick={(() => deleteTodo(props.id))}>
                  <FaTrash style={{color: '', fontsize: '16px'}}/>
              </button>
              <span style={{ textDecoration: props.completed ? 'line-through' : 'none' }}>
                  {/* 체크박스 누르면 취소선 그어지도록 */}
                  {props.title}
              </span>
          </div>
          {editing && <input type="text" ref={editInputRef} defaultValue={props.title} onKeyDown={handleUpdatedDone} />}
          {/* 여기서 editing이 true일 때, false일 때 설정되는 것 */}
      </li>
  )
}

export default ZustandTodoItem