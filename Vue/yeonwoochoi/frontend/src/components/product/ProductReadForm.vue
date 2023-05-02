<template lang="">
    <div>
        <table>
            <tr>
                <td>상품 번호</td>
                <td>
                    <input type="text" :value="product.productId" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품명</td>
                <td>
                    <input type="text" :value="product.productName" readonly/>
                </td>
            </tr>
            <tr>
                <td>가격</td>
                <td>
                    <input type="number" :value="product.price" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: "ProductReadForm",
    props: {
        product: {
            type: Object,
            required: true,
        }
    }
}
</script>

<style lang="">
    
</style>