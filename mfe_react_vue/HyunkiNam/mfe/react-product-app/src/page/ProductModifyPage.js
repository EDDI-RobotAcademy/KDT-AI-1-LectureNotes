import React, { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import * as axiosClient from "../api/product"
import ProductModifyForm from '../components/ProductModifyForm'

const ProductModifyPage = ({ match, history }) => {
  const { productId } = useParams()

  const [product, setProduct] = useState(null)

  const navigate = useNavigate()

  const onModify = async (productId, productName, price) => {
    try {
      await axiosClient.modifyProduct(productId, productName, price)
      alert('게시물 수정 성공!')
      navigate("/read/" + productId)
    } catch (e) {
      console.log(e)
    }
  }

  const readProduct = async (productId) => {
    try {
      const response = await axiosClient.fetchProduct(productId)
      setProduct(response.data)
    } catch (e) {
      throw e
    }
  }

  useEffect(() => {
    readProduct(productId)
  }, [productId])

  return (
    <ProductModifyForm product={product} onModify={onModify} />
  )
}

export default ProductModifyPage