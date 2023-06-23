import React, { useCallback, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductRegisterForm = ({ onRegister }) => {
  const [name, setName] = useState("")
  const [price, setPrice] = useState("")
  const [manufacturer, setManufacturer] = useState("")
  const [expirationDate, setExpirationDate] = useState("")
  const [productionDate, setProductionDate] = useState("")
  const [details, setDetails] = useState("")

  const handleChangeName = useCallback((e) => {
    setName(e.target.value)
  }, [])

  const handleChangePrice = useCallback((e) => {
    setPrice(e.target.value)
  }, [])

  const handleChangeManufacturer = useCallback((e) => {
    setManufacturer(e.target.value)
  }, [])

  const handleChangeExpirationDate = useCallback((e) => {
    setExpirationDate(e.target.value)
  }, [])

  const handleChangeProductionDate = useCallback((e) => {
    setProductionDate(e.target.value)
  }, [])

  const handleChangeDetails = useCallback((e) => {
    setDetails(e.target.value)
  }, [])

  const handleSubmit = useCallback(
    (e) => {
        e.preventDefault();
        
        onRegister(name, price, manufacturer, expirationDate, productionDate, details)
    },
    [name, price, manufacturer, expirationDate, productionDate, details, onRegister]
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
                <input type="text" value={name} onChange={handleChangeName}/>
              </td>
            </tr>
            <tr>
              <td>가격</td>
              <td>
                <input type="text" value={price} onChange={handleChangePrice}/>
              </td>
            </tr>
            <tr>
              <td>제조사</td>
              <td>
                <input type="text" value={manufacturer} onChange={handleChangeManufacturer}/>
              </td>
            </tr>
            <tr>
              <td>유통기한</td>
              <td>
                <input type="text" value={expirationDate} onChange={handleChangeExpirationDate}/>
              </td>
            </tr>
            <tr>
              <td>제조일자</td>
              <td>
                <input type="text" value={productionDate} onChange={handleChangeProductionDate}/>
              </td>
            </tr>
            <tr>
              <td>상품정보</td>
              <td>
                <textarea rows="5" value={details} onChange={handleChangeDetails}/>
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

export default ProductRegisterForm