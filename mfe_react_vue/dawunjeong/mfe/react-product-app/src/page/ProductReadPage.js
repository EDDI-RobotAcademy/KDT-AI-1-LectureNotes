import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/product"
import ProductReadForm from '../components/ProductReadForm'

const ProductReadPage = () => {
  const { productId } = useParams()

  const [product, setProducts] = useState(null)
  const [isLoading, setLoading] = useState(false)

  const navigate = useNavigate()

  const readProduct = async (productId) => {
    setLoading(true)
    try {
        const response = await axiosClient.fetchProduct(productId)
        setProducts(response.data)
        setLoading(false)
    } catch (e) {
        throw e
    }
  }

  const onRemove = async () => {
    try {
        await axiosClient.removeProduct(productId)
        alert("상품이 삭제되었습니다!")
        navigate("/")
    } catch (e) {
        console.log(e)
    }
  }
  useEffect(() => {
    readProduct(productId)
  }, [productId])

  return <ProductReadForm productId={productId} product={product} isLoading={isLoading} onRemove={onRemove}/>
}

export default ProductReadPage