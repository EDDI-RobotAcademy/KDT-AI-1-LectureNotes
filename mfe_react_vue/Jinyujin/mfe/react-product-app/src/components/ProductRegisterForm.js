import React, { useCallback, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductRegisterFrom = ({ onRegister }) => {
  const [productName, setProductName] = useState("")
  const [price, setPrice] = useState("")

  const handleChangeProductName = useCallback((e) => {
    setProductName(e.target.value)
  }, [])
  const handleChangePrice = useCallback((e) => {
    setPrice(e.target.value)
  }, [])

  const handleSubmit = useCallback(
    (e) => {
      e.preventDefault();
      
      onRegister(productName, price)
    },
    [productName, price, onRegister]
  )

  return (
    <div align="center">
    <h2>상품 등록</h2>
    <form onSubmit={handleSubmit}>
        <table>
          <tbody>
            <tr>
              <td>상품명</td>
              <td>
                <input type="text" value={productName} onChange={handleChangeProductName}></input>
              </td>
            </tr>
            <tr>
              <td>가격</td>
              <td>
                <input type="number" value={price} onChange={handleChangePrice}></input>
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

export default ProductRegisterFrom