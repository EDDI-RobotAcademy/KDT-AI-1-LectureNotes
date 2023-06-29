import React, { useState } from 'react'
import { FaPlusCircle } from 'react-icons/fa'
import { useTodoStore } from '../zustand/store'

// todo 입력 폼
const ZustandInputTodo = () => {
    const [title, setTitle] = useState("")
    const [message, setMessage] = useState("")
    // state를 사용하면 데이터가 자동으로 재렌더링 되어짐

    const addTodoItem = useTodoStore((state) => state.addTodoItem)
    const handleChange = (e) => {
        setTitle(e.target.value)
    }

    const handleSubmit = (e) => {
        e.preventDefault()

        if (title.trim()) {
            // trim: 문자열 좌우에서 공백을 제거하는 함수
            addTodoItem(title)
            setTitle('')
            setMessage('')
        } else {
            setMessage('올바르게 입력 해주세요')
            // 빈칸에 아무것도 안쓰고 엔터치면 이 메세지 나옴
        }
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder='todo 입력'
                    value={title}
                    onChange={handleChange} />
                <button>
                    <FaPlusCircle
                        style={{ color: '', fontSize: '10px', marginTop: '2px' }} />
                </button>
            </form>
            <span>{message}</span>
        </div>
    )
}

export default ZustandInputTodo