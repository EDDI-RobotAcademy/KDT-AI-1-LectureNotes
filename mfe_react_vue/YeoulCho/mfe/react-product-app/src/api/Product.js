import axios from "axios"

export const fetchProductList = () => axios.get("http://localhost:7777/jpa-product/list")
export const registerProduct = (productName, price) => axios.post("http://localhost:7777/jpa-product/register", {productName, price})

export const removeProduct =(productId) => axios.delete(`http://localhost:7777/jpa-product/${productId}`)

export const fetchProduct = (productId) => axios.get(`http://localhost:7777/jpa-product/${productId}`)

export const modifyProduct = (productId, productName,price) => 
    axios.put(`http://localhost:7777/jpa-product/${productId}`, { productName,price})