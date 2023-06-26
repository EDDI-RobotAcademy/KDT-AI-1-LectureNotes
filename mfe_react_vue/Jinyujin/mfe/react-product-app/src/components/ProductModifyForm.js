import React, { useCallback, useEffect, useState } from 'react'
import { Link } from 'react-router-dom' // imrr

const ProductModifyForm = ({ product, isLoading, onModify }) => {
    const [productName, setProductName] = useState("")
    const [price, setPrice] = useState("")

    const handleChangeProductName = useCallback((e) => {
        setProductName(e.target.value)
    }, [])
    const handleChangePrice = useCallback((e) => {
        setPrice(e.target.value)
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();

        onModify(product.productId, productName, price)
    }

    useEffect(() => {
        if (product) {
            setProductName(product.productName)
            setPrice(product.price)
        }
    }, [product])
    
    return (
        <div align="center">
            <h2>게시물 수정</h2>
            {isLoading && "로딩중 ..........."}
            {!isLoading && product && (
                <>
                <form onSubmit={handleSubmit}>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>번호</td>
                                <td>
                                        <input type="text" value={product.productId} disabled />
                                </td>
                        </tr>
                        <tr>
                            <td>상품명</td>
                                <td>
                                        <input type="text" value={productName} onChange={handleChangeProductName} />
                                </td>
                        </tr>
                            <tr>
                                <td>가격</td>
                                <td>
                                        <input type="text" defaultValue={price} onChange={handleChangePrice} />
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