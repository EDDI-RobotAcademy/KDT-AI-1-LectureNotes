import { create } from 'zustand'
import { persist } from 'zustand/middleware'
import { v4 as uuidv4 } from 'uuid'

const todoStore = (set) => ({
    todos: [],
    addTodoItem: (title) => {
        const newTodo = {
            id: uuidv4(),
            title: title,
            completed: false,
        }
        set((state) => ({
            todos: [...state.todos, newTodo]
            //... -> todos를 배열이 아닌 상태로 전개연산자로 가지고 옴
        }))
    },
    deleteTodo: (id) => {
        set((state) => ({
            todos: state.todos.filter((todo) => {
                return todo.id !== id
            })
        }))
    },
    handleChange: (id) => {
        set((state) => ({
            todos: state.todos.map((todo) => {
                if (todo.id === id) {
                    return {
                        ...todo,
                        // 구조 분해 할당
                        // id: todo.id, title: todo.title, complete: todo.complete 
                        completed: !todo.completed,
                    }
                }
                return todo
            })
        }))
    },
    setUpdate: (updatedTitle, id) => {
        set((state) => ({
            todos: state.todos.map((todo) => {
                if (todo.id === id) {
                    todo.title = updatedTitle
                }
                return todo
            })
        }))
    }
})

export const useTodoStore = create(
    persist(todoStore, {
        name: 'todos',
    })
)