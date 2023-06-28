import React, { useRef, useState } from 'react'
import { useTodoStore } from '../zustand/store'
import { AiFillEdit} from 'react-icons/ai'

const ZustandTodoItem = ({props}) => {
    const [editing, setEditing] = useState(false)

    // 사실상 Vue의  ...mapMutatilns( ) 혹은 ...mapActions와 동일하다 볼 수 있음
    // 보면 actions 요청인지, state 가져오는지, mutation 작업인지는 결국 우리가 잘 판단해야함
    // 그러므로 Vue 스타일로 이것을 바라본다면 아래와 같이 매서드 명에 구분을 할 수 있도록 만들어주는 수 밖에 없음
    // 네이밍을 할 때  handleChangeForMutation = useTodoStore((State)=>state.handleChangeForMutation)
    // 이 스타일을 따라간다면 todosForState =useTodoStore((state)=>state.todoForState)
    const handleChange = useTodoStore((state)=>state.handleChange)
    const deleteTodo = useTodoStore((state)=>state.deleteTodo)
    const setUpdate = useTodoStore((state)=> state.setUpdate)
    const editInputRef =useRef(null)
    const handleEditing = ()=>{
        setEditing(true)
    }

  return (
    <div><input type='chechbox' checked={props.completed} onChange={()=>handleChange(props.id)}/>
    <button onClick={handleEditing}>버튼</button>
    </div>
  )
}

export default ZustandTodoItem