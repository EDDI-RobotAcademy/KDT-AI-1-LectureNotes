import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import ProductReadForm from '../components/ProductReadForm'
import * as axiosClient from '../api/product'

const ProductReadPage = () => {
    const { productId } = useParams()
    const [product, setProduct] = useState(null)
    // const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const onRead = async (productId) => {
        // setLoading(true)
        try {
            const response = await axiosClient.fetchProduct(productId)

            setProduct(response.data)
            // setLoading(false)
        } catch (e) {
            console.log(e)
        }
    }
    const onRemove = async () => {
        try {
            await axiosClient.removeProduct(productId)
            navigate('/')
        } catch (e) {
            console.log(e)
        }
    }
    useEffect(() => {
        onRead(productId)
    }, [productId])

    return <ProductReadForm productId={productId} product={product} onRemove={onRemove} />
}

export default ProductReadPage