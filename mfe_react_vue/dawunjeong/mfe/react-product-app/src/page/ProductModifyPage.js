import React, { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import * as axiosClient from "../api/product"
import ProductModifyForm from '../components/ProductModifyForm'

const ProductModifyPage = () => {
  const { productId } = useParams()

  const [product, setProduct] = useState(null)
  const [isLoading, setLoading] = useState(false)

  const navigate = useNavigate()

  const onModify = async (productId, name, price, manufacturer, expirationDate, productionDate, details) => {
    try {
      await axiosClient.modifyProduct(productId, name, price, manufacturer, expirationDate, productionDate, details)
      alert('상품이 성공적으로 수정되었습니다!')
      navigate("/read/" + productId)
    } catch (e) {
      console.log(e)
    }
  }

  const readProduct = async (productId) => {
    setLoading(true)

    try {
      const response = await axiosClient.fetchProduct(productId)
      setProduct(response.data)
      setLoading(false)
    } catch (e) {
      throw e
    }
  }

  useEffect(() => {
    readProduct(productId)
  }, [productId])

  return (
    <ProductModifyForm product={product} isLoading={isLoading} onModify={onModify}/>
  )
}

export default ProductModifyPage