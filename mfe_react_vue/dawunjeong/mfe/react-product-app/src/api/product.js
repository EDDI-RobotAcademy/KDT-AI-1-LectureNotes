import axios from "axios"

export const fetchProductList = () => axios.get("http://localhost:7777/jpa-product/list")

export const registerProduct = (name, price, manufacturer, expirationDate, productionDate, details) => 
    axios.post("http://localhost:7777/jpa-product/register", { name, price, manufacturer, expirationDate, productionDate, details})

export const fetchProduct = (productId) => axios.get(`http://localhost:7777/jpa-product/${productId}`)

export const removeProduct = (productId) => axios.delete(`http://localhost:7777/jpa-product/${productId}`)

export const modifyProduct = (productId, name, price, manufacturer, expirationDate, productionDate, details) => 
    axios.put(`http://localhost:7777/jpa-product/${productId}`, { name, price, manufacturer, expirationDate, productionDate, details })