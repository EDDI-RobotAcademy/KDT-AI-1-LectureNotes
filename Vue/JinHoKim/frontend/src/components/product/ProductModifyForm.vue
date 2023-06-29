<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>상품 번호</td>
                    <td>
                        <input type="text" :value="product.productId" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" v-model="productName"/>
                    </td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td>
                        <input type="number" v-model="price"/>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ 
                    name: 'ProductReadPage', 
                    params: { productId: product.productId.toString() }
                }">수정 취소</router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    props: {
        product: {
            type: Object,
            required: true,
        }
    },
    data () {
        return {
            productName: '',
            price: 0,
        }
    },
    created () {
        this.productName = this.product.productName
        this.price = this.product.price
    },
    methods: {
        onSubmit () {
            const { productName, price } = this
            this.$emit('submit', { productName, price })
        }
    }
}
</script>

<style lang="">
    
</style>