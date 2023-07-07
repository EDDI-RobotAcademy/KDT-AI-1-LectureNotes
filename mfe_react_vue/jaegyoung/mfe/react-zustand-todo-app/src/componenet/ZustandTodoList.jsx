import React from 'react'
import { useTodoStore } from '../zustand/store'
import ZustandTodoItem from './ZustandTodoItem'

const ZustandTodoList = () => {
    const todos = useTodoStore((state)=>state.todos)

  return (
   <ul>
    {todos.map((todo)=>{
        <ZustandTodoItem key={todo.id} props={todo}/>
    })}
   </ul>
  )
}

export default ZustandTodoList