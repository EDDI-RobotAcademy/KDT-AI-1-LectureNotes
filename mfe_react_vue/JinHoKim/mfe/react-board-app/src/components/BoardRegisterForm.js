import React, { useCallback, useState } from 'react' // rafce
import { Link } from 'react-router-dom' //imrr


const BoardRegisterForm = ({ onRegister }) => {
  const [title, setTitle] = useState("")
  const [content, setContent] = useState("")
  const [writer, setWriter] = useState("")

  const handleChangeTitle = useCallback((e) => {
    setTitle(e.target.value)
  }, [])

  const handleChangeContent = useCallback((e) => {
    setContent(e.target.value)
  }, [])

  const handleChangeWriter = useCallback((e) => {
    setWriter(e.target.value)
  }, [])

  const handleSubmit = useCallback((e) => {
    (e) => {
        e.preventDefault();
        
        onRegister(title, content, writer)
    },
    [title, content, writer, onRegister]
  })
  
  return (
    <div>
      <h2>게시물 등록</h2>
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>제목</td>
              <td>
                {/* React는 v-model이 없어서 onChange랑 위의 useCallback을 묶어서 사용 */}
                <input type='text' value={title} onChange={handleChangeTitle}/>
              </td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>
                <input type='text' value={writer} onChange={handleChangeWriter}/>
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <textarea rows="5" value={content} onChange={handleChangeContent}/>
              </td>
            </tr>
          </tbody>
        </table>
        <div>
          <button type='submit'>등록</button>
          <Link to="/">취소</Link>
        </div>
      </form>
    </div>
  )
}

export default BoardRegisterForm