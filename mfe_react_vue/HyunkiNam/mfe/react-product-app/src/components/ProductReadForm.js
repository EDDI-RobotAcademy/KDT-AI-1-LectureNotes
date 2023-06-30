import React from 'react'
import { Link } from 'react-router-dom' // imrr

const ProductReadForm = ({ productId, product, onRemove }) => {
    return (
        <div>
            <h2>상품 정보</h2>
            {product && (
                <>
                    <table border="1">
                        <tbody>
                            <tr>
                                <td>번호</td>
                                <td>
                                    <input type="text" value={product.productId} readOnly />
                                </td>
                            </tr>
                            <tr>
                                <td>상품명</td>
                                <td>
                                    <input type="text" value={product.productName} readOnly />
                                </td>
                            </tr>
                            <tr>
                                <td>가격</td>
                                <td>
                                    <input type="text" value={product.price} readOnly />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <Link to={`/modify/${productId}`}>수정</Link>
                    <button onClick={onRemove}>삭제</button>
                    <Link to='/'>돌아가기</Link>
                </>
            )}
        </div>
    )
}

export default ProductReadForm