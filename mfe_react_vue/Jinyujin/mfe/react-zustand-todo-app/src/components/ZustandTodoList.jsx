import React from 'react'
import ZustandTodoItem from './ZustandTodoItem'
import { useTodoStore } from '../zustand/store'

// todo 입력하면 todo list 생성되도록
const ZustandTodoList = () => {
  // Vue ...mapState() 와 동일함
    const todos = useTodoStore((state) => state.todos)
    
  return (
      <ul>
          {todos.map((todo) => (
              <ZustandTodoItem key={todo.id} props={todo} />
          ))}
    </ul>
  )
}

export default ZustandTodoList