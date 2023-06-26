import React from 'react'
import { Link } from 'react-router-dom' // imrr

const ProductReadForm = ({ productId, product, isLoading, onRemove }) => {
  return (
      <div align="center">
        <h2>상세 보기</h2>
          {isLoading && "로딩중 ..........."}
          {!isLoading && product && (
              <>
                  <table border="1">
                      <tbody>
                          <tr>
                              <td>번호</td>
                              <td>
                                  <input type="text" value={product.productId} readonly />
                              </td>
                          </tr>
                          <tr>
                              <td>상품명</td>
                              <td>
                                  <input type="text" value={product.productName} readonly />
                              </td>
                          </tr>
                          <tr>
                              <td>가격</td>
                              <td>
                                  <input type="text" value={product.price} readonly />
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