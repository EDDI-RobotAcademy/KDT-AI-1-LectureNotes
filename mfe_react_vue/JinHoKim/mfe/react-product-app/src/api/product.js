import axios from "axios"

export const fetchProductList = () => axios.get("http://localhost:7777/jpa-product/list")

export const registerProduct = (title, content, writer) => 
    axios.post("http://localhost:7777/jpa-product/register", { title, content, writer })

export const fetchProduct = (productId) => axios.get(`http://localhost:7777/jpa-product/${productId}`)

export const removeProduct = (productId) => axios.delete(`http://localhost:7777/jpa-product/${productId}`)

export const modifyProduct = (productId, title, content, writer) => 
    axios.put(`http://localhost:7777/jpa-product/${productId}`, { title, content, writer })