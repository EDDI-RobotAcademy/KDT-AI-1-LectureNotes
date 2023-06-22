import React from 'react'
import { useNavigate } from 'react-router-dom'
import * as axiosClient from "../api/product"
import ProductRegisterForm from '../components/ProductRegisterForm'

const ProductRegisterPage = ({ history }) => {
  const navigate = useNavigate()

  const onRegister = async (name, price, manufacturer, expirationDate, productionDate, details) => {
    try {
        const response = await axiosClient.registerProduct(name, price, manufacturer, expirationDate, productionDate, details)
        alert('상품 등록 성공!')
        navigate("/read/" + response.data.productId)
    } catch (e) {
        console.log(e)
    }
  }

  return <ProductRegisterForm onRegister={onRegister}/>
}

export default ProductRegisterPage