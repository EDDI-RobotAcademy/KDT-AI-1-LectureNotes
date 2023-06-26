import React from 'react'
import { Link } from 'react-router-dom'

const ProductReadForm = ({ productId, product, isLoading, onRemove }) => {
  return (
    <div>
      <h2>게시물 조회</h2>
      { isLoading && "로딩중 .........." }
      { !isLoading && product && (
        <>
            <table border="1">
                <tbody>
                    <tr>
                        <td>번호</td>
                        <td>
                            <input type="text" value={product.productId} readOnly/>
                        </td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td>
                            <input type="text" value={product.productName} readOnly/>
                        </td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td>
                            <input type="text" value={product.price} readOnly/>
                        </td>
                    </tr>
                </tbody>
            </table>

            <Link to={`/modify/${productId}`}>수정</Link>
            <button onClick={onRemove}>삭제</button>
            <Link to="/">돌아가기</Link>
        </>
      )}
    </div>
  )
}

export default ProductReadForm