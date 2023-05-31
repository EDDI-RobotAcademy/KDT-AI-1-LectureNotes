<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>사업자 계정 email</td>
                    <td>
                        <input type="text" v-model="email">
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" v-model="productName">
                    </td>
                </tr>
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text" v-model="productPrice">
                    </td>
                </tr>
            </table>
            <v-btn type="submit">완료</v-btn>
        </form>
    </div>
</template>

<script>
export default {
    data () {
        return {
            email: '',
            productName: '',
            productPrice: 0,
        }
    },
    methods: {
        onSubmit () {
            const { email, productName, productPrice } = this
            this.$emit('submit', { email, productName, productPrice })
        },
    }
}
</script>

<style lang="">
    
</style>