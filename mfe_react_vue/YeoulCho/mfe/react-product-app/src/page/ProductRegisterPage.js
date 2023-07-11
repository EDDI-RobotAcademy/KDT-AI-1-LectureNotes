import React from 'react'
import ProductRegisterForm from '../components/ProductRegisterForm'
import * as axiosClient from "../api/Product"
import { useNavigate } from 'react-router-dom'

const ProductRegisterPage = () => {
    const navigate = useNavigate()
    const onRegister = async (productName, price) => {
        try{
            const response = await axiosClient.registerProduct(productName, price)
            alert("상품 등록 성공!")
            navigate("/react-product-app/read/"+response.data.productId)
        } catch(e) {
            throw e
        }
    }
  return <ProductRegisterForm onRegister={onRegister}/>

}

export default ProductRegisterPage