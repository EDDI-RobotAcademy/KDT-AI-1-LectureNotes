import React from 'react'
import ZustandTodoItem from './ZustandTodoItem'
import { useTodoStore } from '../zustand/store'

const ZustandTodoList = () => {
  // Vue ...mapState()와 동일함
  const todos = useTodoStore((state) => state.todos)

  return (
    <div>
      <ul>
        { todos.map((todo) => (
            <ZustandTodoItem key={todo.id} props={todo}/>
        ))}
      </ul>
    </div>
  )
}

export default ZustandTodoList