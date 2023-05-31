<template lang="">
    <div>
        <table>
            <tr>
                <td>상품 번호</td>
                <td>
                    <input type="text" :value="product.id" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품명</td>
                <td>
                    <input type="text" :value="product.productName" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품 가격</td>
                <td>
                    <input type="text" :value="product.productPrice" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
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