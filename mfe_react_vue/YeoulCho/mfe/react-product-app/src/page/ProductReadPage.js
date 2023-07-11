import React, { useEffect, useState } from 'react'
import ProductReadForm from '../components/ProductReadForm'
import * as axiosClient from "../api/Product"
import { useNavigate, useParams } from 'react-router-dom'
const ProductReadPage = () => {
    const {productId} =useParams()

    const [ product, setProduct] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const readProduct = async (productId) =>{
        setLoading(true)
        try{
            const response = await axiosClient.fetchProduct(productId)
            setProduct(response.data)
            setLoading(false)
        } catch(e){
            throw e
        }
    }

    const onRemove = async () => {
        try{
            await axiosClient.removeProduct(productId)
            alert("상품이 삭제 되었습니다.")
            navigate("/react-product-app")
        } catch(e){
            throw e
        }
    }

    useEffect(()=>{
        readProduct(productId)
    },[productId])
  return <ProductReadForm productId={productId} product={product} isLoading={isLoading} onRemove={onRemove}/>
}

export default ProductReadPage