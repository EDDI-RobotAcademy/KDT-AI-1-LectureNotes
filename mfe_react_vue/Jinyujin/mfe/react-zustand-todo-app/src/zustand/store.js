import { create } from 'zustand'
import { persist } from 'zustand/middleware'
// persist: 상태를 localstorage에 저장하고 복원하는 기능
// -> 새로고침해도 상태가 유지된다
import { v4 as uuidv4 } from 'uuid'

// store에서 상태(state)와 actions를 관리하는 듯함 
const todoStore = (set) => ({
    todos: [], // todos를 배열로 초기화

// 각각 actions가 set을 통해 상태를 업데이트
    // todo 추가
    addTodoItem: (title) => {
        // title을 매개변수로 받음
        const newTodo = {
            id: uuidv4(),
            // 스프링 uuid처럼 고유값 생성
            title: title,
            completed: false,
            // completed: 할 일 항목의 완료 여부  
            // 새로운 todo가 추가될 때마다 false로 초기화 (완료되지 않았음)
        }
        set((state) => ({
            todos: [...state.todos, newTodo]
        }))
        // todos 배열은 state.todos를 사용하여 새 배열로 복사됨
        // newTodo가 todos 배열의 끝에 추가됨
    },
    // todo 삭제
    deleteTodo: (id) => {
        // id를 매개변수로 받음
        set((state) => ({
            todos: state.todos.filter((todo) => {
                return todo.id !== id
                // todo.id가 주어진 id와 일치하지 않는 것만 남김
                // 즉 일치하는건 삭제
            })
        }))
    },
    // ?
    handleChange: (id) => {
        set((state) => ({
        // set함수를 통해 state 상태를 변경
            todos: state.todos.map((todo) => {
            // todos 배열을 map함수를 사용하여 새로운 배열로 변환
                if (todo.id === id) {
                    return {
                        ...todo,
                        // ...으로 나머지 요소 가져올 수 있음
                        // 여기서는 나머지 todo 가져와라

                        // 예시)
                        // let [name1, name2, ...rest] =["Julius", "Caesar", "Consul", "of the Roman Republic"];

                        // alert(name1); // Julius
                        // alert(name2); // Caesar

                        // `rest`는 배열입니다.
                        // alert(rest[0]); // Consul
                        // alert(rest[1]); // of the Roman Republic
                        // alert(rest.length); // 2

                        completed: !todo.completed,
                        // 현재 완료 상태 속성 토글
                        // 토글: 스위치 누르면 껐다 켜지는 것처럼
                        // 하나의 설정 값이 다른 값으로 전환하는 것
                    }

                // todo에 있는 id가 매개변수 id와 같다면 나머지 todo들을 가져와서
                // 현재 완료 상태를 전환해라
                }
                return todo
            })
        }))
    },
    // todo 제목을 업데이트
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
    // create: zustand 스토어를 생성
    persist(todoStore, {
    // persist: zustand 상태를 지속적으로 저장
    // persist 첫 번째 매개변수로 todoStore 전달
    // persist 두 번째 매개변수로 객체 전달
        name: 'todos',
    })
)
// zustand를 사용하여 'todos'라는 이름으로 상태를 지속적으로 저장하는 useTodoStore 생성
// 상태가 변경될 때마다 해당 상태가 로컬 스토리지에 저장되고, 
// 애플리케이션이 다시 실행될 때 이전에 저장된 상태가 불러와진다