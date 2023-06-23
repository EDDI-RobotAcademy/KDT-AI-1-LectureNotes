import React, { useCallback, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductRegisterForm = ({ onRegister }) => {
  const [productName, setProductName] = useState("")
  const [price, setPrice] = useState("")

  // React는 v-model이 없습니다.
  // 다 이렇게 만드세요.
  const handleChangeProductName = useCallback((e) => {
    setProductName(e.target.value)
  }, [])

  const handleChangePrice = useCallback((e) => {
    setPrice(e.target.value)
  }, [])

  const handleSubmit = useCallback(
    (e) => {
        // vue에서 prevent() 써서 submit 막고 커스텀 submit 처리하려고함
        e.preventDefault();
        
        onRegister(productName, price)
    },
    [productName, price, onRegister]
    // title, content, writer, onRegister 중 하나라도 바뀌면 실행
  )

  return (
    <div align="center">
      <h2>게시물 등록</h2>
      <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>상품명</td>
              <td>
                {/* React는 v-model이 없어서 onChange랑 위의 useCallback을 묶어서 사용 */}
                <input type="text" value={title} onChange={handleChangeProductName}/>
              </td>
            </tr>
            <tr>
              <td>상품 가격</td>
              <td>
                <input type="text" value={writer} onChange={handleChangePrice}/>
              </td>
            </tr>
          </tbody>
        </table>

        <div>
          <button type="submit">등록</button>
          <Link to="/">취소</Link>
        </div>
      </form>
    </div>
  )
}

export default BoardRegisterForm