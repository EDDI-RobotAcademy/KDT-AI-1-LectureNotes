import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/Product"
import ProductModifyForm from '../components/productModifyForm'

const ProductModifyPage = () => {
    const {productId} = useParams()
    const [product, setProduct] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const onModify = async (productId, productName, price ) =>{
        try {
            await axiosClient.modifyProduct(productId, productName, price)
            alert ("상품이 수정되었습니다.")
            navigate("/react-product-app/read/" + productId)
        } catch(e) {
            throw e
        }
    }
    const readProduct = async(productId) => {
        setLoading(true)
        try{
            const response = await axiosClient.fetchProduct(productId)
            setProduct(response.data)
            setLoading(false)
        } catch (e){
            throw e
        }
    }
    useEffect(()=>{
        readProduct(productId)
    },[productId])
  return <ProductModifyForm product={product} onModify={onModify} isLoading={isLoading} />
}

export default ProductModifyPage