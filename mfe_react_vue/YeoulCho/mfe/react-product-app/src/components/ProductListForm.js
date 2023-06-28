import React from 'react'
import { Link } from 'react-router-dom'


const ProductListForm = ( {products, isLoading}) => {
  return (
    <div>
        <h2> React로 만드는 상품게시판</h2>
        {isLoading && "로딩중..............."}
        {!isLoading && products && (
            <>
            <Link to="/react-product-app/register">상품 등록하기</Link>
            <table>
                <thead>
                    <tr>
                        <th align='center' width="100">
                            번호
                        </th>
                        <th align='center' width="200">
                            상품명
                        </th>
                        <th align='center' width="100">
                            가격
                        </th>
                    </tr>
                </thead>
                <tbody>
                    { !products.length ? (
                        <tr>
                            <td colSpan={3}>
                                등록된 상품이 존재하지 않습니다.
                            </td>
                        </tr>
                    ): (products.map((product) =>(
                        <tr key={product.productId}>
                            <td align="center">{product.productId}</td>
                            <td align="left"><Link to={`/react-product-app/read/${product.productId}`}>{product.productName}</Link></td>
                            <td align="right">{product.price}</td>
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