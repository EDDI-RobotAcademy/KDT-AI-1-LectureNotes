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
                    <input type="text" :value="product.name" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품 가격</td>
                <td>
                    <input type="text" :value="product.price" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조사</td>
                <td>
                    <input type="text" :value="product.manufacturer" readonly/>
                </td>
            </tr>
            <tr>
                <td>유통기한</td>
                <td>
                    <input type="text" :value="product.expirationDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>제조일</td>
                <td>
                    <input type="text" :value="product.productionDate" readonly/>
                </td>
            </tr>

            <tr>
                <td>상품 정보</td>
                <td>
                    <textarea cols="80" rows="30" :value="product.details" readonly/>
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