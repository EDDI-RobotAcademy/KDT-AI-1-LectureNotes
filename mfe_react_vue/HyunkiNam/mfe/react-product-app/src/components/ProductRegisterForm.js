import React, { useCallback, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductRegisterForm = ({ onRegister }) => {
    const [productName, setProductName] = useState("")
    const [price, setPrice] = useState("")

    const changeProductName = (e) => {
        setProductName(e.target.value)
    }
    const changePrice = (e) => {
        setPrice(e.target.value)
    }

    const onSubmit = (e) => {
        e.preventDefault()
        onRegister(productName, price)
    }

    return (
        <div align="center">
            <h2>상품 등록</h2>
            <form onSubmit={onSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>상품명</td>
                            <td>
                                <input type="text" value={productName} onChange={changeProductName} />
                            </td>
                        </tr>
                        <tr>
                            <td>가격</td>
                            <td>
                                <input type="text" value={price} onChange={changePrice} />
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