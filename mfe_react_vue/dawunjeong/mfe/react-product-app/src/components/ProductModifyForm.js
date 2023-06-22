import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductModifyForm = ({ product, isLoading, onModify }) => {
  const [name, setName] = useState("")
  const [price, setPrice] = useState("")
  const [expirationDate, setExpirationDate] = useState("")
  const [productionDate, setProductionDate] = useState("")
  const [details, setDetails] = useState("")

  const handleChangeName = (e) => {
    setName(e.target.value)
  }

  const handleChangePrice = (e) => {
    setPrice(e.target.value)
  }

  const handleChangeExpirationDate = (e) => {
    setExpirationDate(e.target.value)
  }


  const handleChangeProductionDate = (e) => {
    setProductionDate(e.target.value)
  }


  const handleChangeDetails = (e) => {
    setDetails(e.target.value)
  }


  const handleSubmit = (e) => {
    e.preventDefault();
    
    onModify(product.productId, name, price, product.manufacturer, expirationDate, productionDate, details)
  }

  useEffect(() => {
    if (product) {
      setName(product.name)
      setPrice(product.price)
      setExpirationDate(product.expirationDate)
      setProductionDate(product.productionDate)
      setDetails(product.details)
    }
  }, [product])

  return (
    <div align="center">
      <h2>상품 수정</h2>
      { isLoading && "로딩중 .........." }
      { !isLoading && product && (
        <>
            <form onSubmit={handleSubmit}>
                <table border="1">
                    <tbody>
                    <tr>
                  <td>번호</td>
                  <td>
                    <input type="text" value={ product.productId } disabled/>
                  </td>
                </tr>
                <tr>
                  <td>상품명</td>
                  <td>
                    <input type="text" value={ name } onChange={handleChangeName}/>
                  </td>
                </tr>
                <tr>
                  <td>가격</td>
                  <td>
                    <input type="text" value={ price } onChange={handleChangePrice}/>
                  </td>
                </tr>
                <tr>
                  <td>제조사</td>
                  <td>
                    <input type="text" value={ product.manufacturer } disabled/>
                  </td>
                </tr>
                <tr>
                  <td>유통기한</td>
                  <td>
                    <input type="text" value={ expirationDate } onChange={handleChangeExpirationDate}/>
                  </td>
                </tr>
                <tr>
                  <td>제조일자</td>
                  <td>
                    <input type="text" value={ productionDate } onChange={handleChangeProductionDate}/>
                  </td>
                </tr>
                <tr>
                  <td>상품정보</td>
                  <td>
                    <textarea value={ details } onChange={handleChangeDetails}/>
                  </td>
                </tr>
                    </tbody>
                </table>

                <div>
                    <button type="submit">수정</button>
                    <Link to={`/read/${product.productId}`}>취소</Link>
                </div>
            </form>
        </>
      )}
    </div>
  )
}

export default ProductModifyForm