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