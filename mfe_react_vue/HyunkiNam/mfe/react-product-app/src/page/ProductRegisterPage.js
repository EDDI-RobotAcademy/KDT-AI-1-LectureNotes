import React from 'react'
import { useNavigate } from 'react-router-dom'
import * as axiosClient from '../api/product'
import ProductRegisterForm from '../components/ProductRegisterForm'

const ProductRegisterPage = () => {
    const navigate = useNavigate()

    const onRegister = async (productName, price) => {
        try {
            const response = await axiosClient.registerProduct(productName, price)

            navigate('/read/' + response.data.productId)
        } catch (e) {
            console.log(e)
        }
    }

    return <ProductRegisterForm onRegister={onRegister} />
}

export default ProductRegisterPage