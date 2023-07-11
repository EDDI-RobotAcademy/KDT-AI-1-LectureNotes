import React, { useCallback, useState } from 'react'
import { Link } from 'react-router-dom'

// emit으로 등록하기 위한 onRegister 전달 받았던 것 넣어줘야 함
const BoardRegisterFrom = ({ onRegister }) => {
  const [title, setTitle] = useState("")
  const [content, setContent] = useState("")
  const [writer, setWriter] = useState("")

// react는 v-model이 없어서 다 아래와 같은 작업이 필요
  const handleChangeTitle = useCallback((e) => {
    setTitle(e.target.value)
  }, [])
  const handleChangeContent = useCallback((e) => {
    setContent(e.target.value)
  }, [])
  const handleChangeWriter = useCallback((e) => {
    setWriter(e.target.value)
  }, []) // [] 비워놓으면 한번만 호출

  // handleSubmit 눌렀을 때 호응 하도록 하는 메서드
  const handleSubmit = useCallback(
    (e) => {
      // vue에서 prevent() 써서 submit막고 커스텀 submit 처리하려고 함
      e.preventDefault();
      
      onRegister(title, content, writer)
    },
    [title, content, writer, onRegister]
    // title, content, writer, onRegister 중 하나라도 바뀌면 실행
    // 트리거가 되는 애들
  )

  return (
    <div align="center">
    <h2>게시물 등록</h2>
    <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>제목</td>
              <td>
                {/* React는 v-model이 없어서 onChangeㅇ랑 위의 useCallback을 묶어서 사용 */}
                <input type="text" value={title} onChange={handleChangeTitle}></input>
              </td>
            </tr>
            <tr>
              <td>작성자</td>
              <td>
                <input type="text" value={content} onChange={handleChangeContent}></input>
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <textarea rows="5" value={writer} onChange={handleChangeWriter}></textarea>
              </td>
            </tr>
          </tbody>
        </table>

        <div>
          <button type="submit">등록</button>
          {/* 
            등록하고 readPage로 가도록 
            쌤은 등록하고 스프링 터미널에 잘 등록되었는지 확인 한번 하심 나도 그러자!
          */}
          <Link to="/react-board-app">취소</Link>
        </div>
      </form>
    </div>
  )
}

export default BoardRegisterFrom