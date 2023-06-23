import React, { useState, useEffect } from 'react'
import ProductListForm from "../components/ProductListForm"
import * as axiosClient from "../api/product"

const ProductListPage = () => {
  const [products, setProducts] = useState([])
  const [isLoading, setLoading] = useState(false)

  const listProduct = async () => {
    setLoading(true)
    try {
        const response = await axiosClient.fetchProductList()

        setProducts(response.data)

        setLoading(false)
    } catch (e) {
        setLoading(false)
        throw e
    }
  }

  useEffect (() => {
    listProduct()
  }, [])

  return <ProductListForm products={products} isLoading={isLoading}/>
}

export default ProductListPage