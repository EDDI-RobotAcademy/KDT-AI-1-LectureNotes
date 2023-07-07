import React, { useState } from 'react'
import FaPlusCircle from 'react-icons/fa'

 const ZustandInputTodo = () => {
    const [title, setTitle] = useState("")
    const [message, setMessage] = useState("")

    const addTodoItem = useTodoStore((state)=>state.addTodoItem)
    const handleChange = (e)=>{
        setTitle(e.target.value)
    }
    const handleSubmit = (e)=>{
        e.preventDefault()
        if(title.trim()){
            addTodoItem(title)
            setTitle('')
            setMessage('')
        } else{
            setMessage('올바르게 입력 해주세요.')
        }
        
    }
  return (
    <div>
        <form onSubmit={handleSubmit} className='form-container'>
            <input 
            type="text"
            placeholder='todo 입력'
            value={title}
            onChange={handleChange}/>
            <button>
                <FaPlusCircle
                style={{color:'blue',fontSize:'20px', marginTop:'2px'}}/>
            </button>

        </form>
    </div>
  )
}
export default ZustandInputTodo
