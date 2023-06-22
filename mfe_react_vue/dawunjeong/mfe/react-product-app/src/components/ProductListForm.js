import React from 'react'
import { Link } from 'react-router-dom'

const ProductListForm = ({ products, isLoading }) => {
  return (
    <div>
      <h2>React로 만든 게시판</h2>
      { isLoading && "로딩중 ..........." }
      { !isLoading && products && (
        <>
          <Link to="/register">상품등록</Link>
          <table border="1">
            <thead>
              <tr>
                <th align='center' width="80">
                  번호
                </th>
                <th align='center' width="320">
                  상품명
                </th>
                <th align='center' width="80">
                  가격
                </th>
                <th align='center' width="80">
                  제조사
                </th>
                <th align='center' width="80">
                  유통기한
                </th>
                <th align='center' width="80">
                  제조일자
                </th>
                <th align='center' width="180">
                  상품정보
                </th>
              </tr>
            </thead>
            <tbody>
              { !products.length ? (
                <tr>
                  <td colSpan={4}>
                    등록된 상품이 존재하지 않습니다!
                  </td>
                </tr>
              ) : ( products.map((product) => (
                <tr key={product.productId}>
                  <td align="center">{ product.productId }</td>
                  <td align="center">
                    <Link to={`/read/${product.productId}`}>{ product.name }</Link>
                  </td>
                  <td align="center">{ product.price }</td>
                  <td align="center">{ product.manufacturer }</td>
                  <td align="center">{ product.expirationDate }</td>
                  <td align="center">{ product.productionDate }</td>
                  <td align="center">{ product.details }</td>
                </tr>
              )))}
            </tbody>
          </table>
        </>
      )}
    </div>
  )
}

export default ProductListForm