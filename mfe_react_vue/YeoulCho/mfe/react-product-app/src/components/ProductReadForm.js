import React from 'react'
import { Link } from 'react-router-dom'

const ProductReadForm = ({productId, product, isLoading, onRemove}) => {
  return (
    <div>
        <h2> 상품 조회 </h2>
        { isLoading && "로딩중..........."}
        {!isLoading && product && (
            <>
            <table>
                <tr>
                    <td>번호</td>
                    <td>
                        <input type="text" value={product.productId} readOnly/>
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" value={product.productName} readOnly/>
                    </td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td>
                        <input type="text" value={product.price} readOnly/>
                    </td>
                </tr>
                </table>
                <Link to={`/react-product-app/modify/${productId}`}>수정</Link>
                <button onClick={onRemove}>삭제</button>
                <Link to="/react-product-app">돌아가기</Link>
                </>)}
</div>
  )}

export default ProductReadForm