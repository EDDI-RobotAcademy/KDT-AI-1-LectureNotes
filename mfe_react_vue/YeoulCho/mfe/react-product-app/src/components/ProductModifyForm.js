import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductModifyForm = ({product, isLoading, onModify}) => {
    const [productName, setProductName] = useState("")
    const [price, setPrice] = useState("")
    
    const handleChangeProductName = (e)=>{
      setProductName(e.target.value)
    }
    const handleChangePrice = (e)=>{
        setPrice(e.target.value)
      }
    
  
    const handleSubmit = (e) =>{
      e.preventDefault();
      onModify(product.productId, productName, price)
    }

    useEffect(() =>{
        if(product){
            setProductName(product.productName)
            setPrice(product.price)
        }
    }, [product])
    return (
      <div aling="center">
        <h2>상품 수정</h2>
        {isLoading && "로딩중.........."}
        {!isLoading && product && (
            <>
        <form onSubmit={handleSubmit}>
          <table>
            <tbody>
              <tr>
                <td>제품명</td>
                <td>
                  <input type="text" value={productName} onChange={handleChangeProductName}/>
                </td>
              </tr>
              <tr>
                <td>가격</td>
                <td>
                  <input type="text" value={price} onChange={handleChangePrice}/>
                </td>
              </tr>
            </tbody>
          </table>
          <div>
            <button type="submit">수정</button>
            <Link to={`/react-product-app/read/${product.productId}`}>취소</Link>
          </div>
        </form>
        </>
        )}
      </div>
    )
  }

export default ProductModifyForm